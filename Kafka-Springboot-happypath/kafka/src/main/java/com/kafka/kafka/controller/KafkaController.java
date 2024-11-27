package com.kafka.kafka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kafka.service.ConsumeService;
import com.kafka.kafka.service.PublishService;

@RestController
@RequestMapping("/kafka/")
public class KafkaController {

    @Autowired
    PublishService publishService;

    @Autowired
    ConsumeService consumeService;

    @PostMapping("/publish")
    public String publishMessage(String message) {
        return publishService.publishMessage(message);
    }

    @GetMapping("/pull")
    public Map<String, String> pullMessage() {
        return consumeService.consumeMessage();
    }

    @PostMapping("/select/{selectedmessage}")
    public String selectedMessage(@PathVariable("selectedmessage") String messagekey) {
        return publishService.publishTombStoneMessage(messagekey);
    }

}