package com.ayshriv.accounts.repository;

import com.ayshriv.accounts.entity.Accounts;
import com.ayshriv.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

}
