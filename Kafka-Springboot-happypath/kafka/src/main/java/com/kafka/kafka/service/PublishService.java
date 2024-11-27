package com.kafka.kafka.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String publishMessage(String message) {
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send("test-topic", key, message);
        return "Message published successfully!!" + message + " with Key " + key;
    }

    public String publishTombStoneMessage(String messageKey)
    {
        kafkaTemplate.send("test-topic", messageKey, null);
        return "TombStone message published successfully!";
    }

}
