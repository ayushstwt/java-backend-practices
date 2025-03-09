package com.ayshriv.accounts.service;

import com.ayshriv.accounts.dto.AccountsDto;
import com.ayshriv.accounts.dto.CustomerDto;
import jakarta.validation.constraints.Pattern;

public interface IAccountsService {

    /**
     * Creates a new account for the customer.
     *
     * @param customerDto the data transfer object containing customer details
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetches account details based on the provided mobile number.
     *
     * @param mobileNumber the mobile number to search for the account
     * @return the customer data transfer object containing account details
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     * Updates the account details for the given customer.
     *
     * @param customerDto the data transfer object containing updated customer details
     * @return true if the update was successful, false otherwise
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     * Deletes the account associated with the given mobile number.
     *
     * @param mobileNumber the mobile number associated with the account
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteAccount(String mobileNumber);
}
