package com.as.banking.Kafka;

import com.as.banking.dto.AccountDto;
import com.as.banking.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Jsonkafkaproducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Jsonkafkaproducer.class);
    private KafkaTemplate<String,Account> kafkaTemplate;

    public Jsonkafkaproducer(KafkaTemplate<String, Account> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
   public void sendMessage(Account accountDto){

        LOGGER.info(String.format("Message send -> %s",accountDto.toString()));
        Message<Account>message=MessageBuilder.withPayload(accountDto).setHeader(KafkaHeaders.TOPIC,"randomtopic").build();
        kafkaTemplate.send(message);
    }
}
