package com.ayshriv.accounts.service.impl;

import com.ayshriv.accounts.constants.AccountConstants;
import com.ayshriv.accounts.constants.CustomerConstants;
import com.ayshriv.accounts.dto.AccountsDto;
import com.ayshriv.accounts.dto.CustomerDto;
import com.ayshriv.accounts.entity.Accounts;
import com.ayshriv.accounts.entity.Customer;
import com.ayshriv.accounts.exception.CustomerAlreadyExistsException;
import com.ayshriv.accounts.exception.ResourceNotFoundException;
import com.ayshriv.accounts.mapper.AccountMapper;
import com.ayshriv.accounts.mapper.CustomerMapper;
import com.ayshriv.accounts.repository.AccountsRepository;
import com.ayshriv.accounts.repository.CustomerRepository;
import com.ayshriv.accounts.service.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

/**
 * @author Ayshriv
 */

@Service
public class AccountServiceImpl implements IAccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Creates a new account for the customer.
     *
     * @param customerDto the data transfer object containing customer details
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(CustomerConstants.CUSTOMER_ALREADY_EXISTS_WITH_MOBILE_NUMBER +customerDto.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * Generates a new account number for the customer and creates a new account
     * object that is saved in the database.
     *
     * @param customer the customer for whom the account is to be created
     * @return the newly created account
     */

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        long randomAccNumber = 10000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setCustomerId(customer.getCustomerId());
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }

    /**
     * Fetches account details for a customer based on the provided mobile number.
     *
     * @param mobileNumber the mobile number to search for the account
     * @return the customer data transfer object containing account details
     * @throws ResourceNotFoundException if the customer or account is not found
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountMapper.mapToAccountsDto(accounts, new AccountsDto()));
        return customerDto;
    }

    /**
     * Updates the account details for the given customer.
     *
     * @param customerDto the data transfer object containing updated customer details
     * @return true if the update was successful, false otherwise
     */
    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if(accountsDto !=null ){
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
    }

    /**
     * Deletes the account for the given customer.
     *
     * @param mobileNumber the mobile number of the customer for whom the account is to be deleted
     * @return true if the delete was successful, false otherwise
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

}
