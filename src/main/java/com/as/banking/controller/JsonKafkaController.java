package com.as.banking.controller;


import com.as.banking.Kafka.Jsonkafkaproducer;
import com.as.banking.dto.AccountDto;
import com.as.banking.entity.Account;
import com.as.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonKafkaController {

    private Jsonkafkaproducer jsonkafkaproducer;
    private AccountService accountService;

    public JsonKafkaController(Jsonkafkaproducer jsonkafkaproducer, AccountService accountService) {
        this.jsonkafkaproducer = jsonkafkaproducer;
        this.accountService = accountService;
    }


    @PostMapping("/publish")
    public ResponseEntity<String>publish(@RequestBody Account account) {

        jsonkafkaproducer.sendMessage(account);
        return ResponseEntity.ok("Message created");
    }
}
