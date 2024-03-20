package com.as.banking.controller;

import com.as.banking.dto.AccountDto;
import com.as.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get account Rest api
    @GetMapping("/{Id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable  Long Id){
        AccountDto accountDto= accountService.getAccountById(Id);
        return  ResponseEntity.ok(accountDto);
    }



    //Deposit

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto>deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.Deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

}
