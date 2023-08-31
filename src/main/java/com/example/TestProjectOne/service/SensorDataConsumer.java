package com.example.TestProjectOne.service;

import com.example.TestProjectOne.dto.SensorData;
import com.example.TestProjectOne.repository.SensorDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SensorDataConsumer {

    private ObjectMapper objectMapper;
    private SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorDataConsumer(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
        this.objectMapper = new ObjectMapper();
    }

    @KafkaListener(topics = "sensor-data")
    public void consume(String message) {
        try {
            SensorData sensorData = objectMapper.readValue(message, SensorData.class);
            sensorDataRepository.save(sensorData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
