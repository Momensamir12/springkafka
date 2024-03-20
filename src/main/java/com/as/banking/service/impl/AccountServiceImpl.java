package com.as.banking.service.impl;

import com.as.banking.dto.AccountDto;
import com.as.banking.entity.Account;
import com.as.banking.mapper.AccountMapper;
import com.as.banking.repository.AccountRepository;
import com.as.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {



    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override

    public AccountDto createAccount(AccountDto accountDto){
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto Deposit(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account doesn't exist"));
        double balance=account.getBalance();
        account.setBalance(balance+amount);
        accountRepository.save(account);
        return AccountMapper.mapToAccountDto(account);
    }
}
