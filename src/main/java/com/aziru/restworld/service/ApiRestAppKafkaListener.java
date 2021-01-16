package com.aziru.restworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ApiRestAppKafkaListener {

    private static final Logger log = LoggerFactory.getLogger(ApiRestAppKafkaListener.class);

    @KafkaListener(topics = "api-rest-app-topic", groupId = "api-rest-app-group")
    public void listen(final String message) {
	log.info("Received Messasge in group foo: {}", message);
    }
}
