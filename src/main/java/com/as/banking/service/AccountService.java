package com.as.banking.service;
import com.as.banking.dto.AccountDto;
import com.as.banking.entity.Account;
public interface AccountService {
    AccountDto createAccount (AccountDto account);
     AccountDto getAccountById(Long id);

    AccountDto Deposit(Long id,double amount);

}
