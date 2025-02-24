package com.as.banking.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public NewTopic randomTopic (){
        return  TopicBuilder.name("randomtopic").build();
    }
}
