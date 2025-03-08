package com.ayshriv.accounts.service;

import com.ayshriv.accounts.dto.AccountsDto;
import com.ayshriv.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Creates a new account for the customer.
     *
     * @param customerDto the data transfer object containing customer details
     */
    void createAccount(CustomerDto customerDto);
}
