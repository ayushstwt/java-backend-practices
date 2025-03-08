package com.ayshriv.accounts.service.impl;

import com.ayshriv.accounts.constants.AccountConstants;
import com.ayshriv.accounts.constants.CustomerConstants;
import com.ayshriv.accounts.dto.CustomerDto;
import com.ayshriv.accounts.entity.Accounts;
import com.ayshriv.accounts.entity.Customer;
import com.ayshriv.accounts.exception.CustomerAlreadyExistsException;
import com.ayshriv.accounts.mapper.CustomerMapper;
import com.ayshriv.accounts.repository.AccountsRepository;
import com.ayshriv.accounts.repository.CustomerRepository;
import com.ayshriv.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

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
        newAccount.setAccountNumber(String.valueOf(randomAccNumber));
        newAccount.setCustomerId(customer.getCustomerId());
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }
}
