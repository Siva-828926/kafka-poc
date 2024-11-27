package com.kafka.kafka.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.kafka.config.RabbitMQConfig;

@Service
public class ConsumeServiceMQ {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void pullMessages() {
        String message = (String) rabbitTemplate.receiveAndConvert(RabbitMQConfig.QUEUE_NAME);
        if (message != null) {
            System.out.println("Received: " + message);
        } else {
            System.out.println("No messages available");
        }
    }

}
