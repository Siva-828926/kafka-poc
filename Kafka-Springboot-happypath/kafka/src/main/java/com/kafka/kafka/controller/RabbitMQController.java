package com.kafka.kafka.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kafka.service.ConsumeServiceMQ;
import com.kafka.kafka.service.PublishServiceMQ;

@RestController
@RequestMapping("/rabbit/")
public class RabbitMQController {

    @Autowired
    PublishServiceMQ publishServiceMQ;

    @Autowired
    ConsumeServiceMQ consumeServiceMQ;

    @PostMapping("/publish")
    public String publishMessage(String message) {
        return publishServiceMQ.publishMessage(message);
    }

    @GetMapping("/pull")
    public Map<String, String> pullMessage() {
        consumeServiceMQ.pullMessages();
        return null;
    }
}
