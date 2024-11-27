package com.kafka.kafka.service;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.kafka.config.RabbitMQConfig;

@Service
public class PublishServiceMQ {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public String publishMessage(String message) {
        String key = UUID.randomUUID().toString();
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, message);
        return "Message published successfully!!" + message + " with Key " + key;
    }

}
