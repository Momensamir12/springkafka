//package com.as.banking.controller;
//
//import com.as.banking.Kafka.KafkaProducer;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/kafka")
//public class MessageController {
//
//    private KafkaProducer kafkaProducer;
//
//    public MessageController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }
//
//    @GetMapping("/publish")
//    public ResponseEntity<String>publish (@RequestParam("message") String message){
//
//        kafkaProducer.sendMessage(message);
//        return ResponseEntity.ok("Message sent to topic");
//    }
//}
