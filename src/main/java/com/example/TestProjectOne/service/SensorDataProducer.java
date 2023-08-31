package com.example.TestProjectOne.service;

import com.example.TestProjectOne.dto.SensorData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SensorDataProducer {
    private ObjectMapper objectMapper;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public SensorDataProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void send(SensorData sensorData) {
        try {
            String message = objectMapper.writeValueAsString(sensorData);
            kafkaTemplate.send("sensor-data", message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
