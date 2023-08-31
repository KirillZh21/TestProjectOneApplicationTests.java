package com.example.TestProjectOne.service;

import com.example.TestProjectOne.dto.SensorData;
import com.example.TestProjectOne.model.Config;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EmulatorService {

    private Config config;
    private SensorDataProducer producer;

    @Autowired
    public EmulatorService(Config config, SensorDataProducer producer) {
        this.config = config;
        this.producer = producer;
    }

    public void start() {
        Random random = new Random();
        LocalDateTime currentTime = config.getTimeEmulation();
        for (int i = 0; i < config.getNumberStep(); i++) {
            for (int j = 0; j < config.getNumberContainer(); j++) {
                SensorData sensorData = new SensorData();
                sensorData.setContainerId(j + 1);
                sensorData.setTimestamp(currentTime.plusSeconds((long) random.nextDouble(config.getMaxTimeShift())));
                Map<String, Double> parameters = new HashMap<>();
                for (ParameterConfig parameterConfig : config.getParameters()) {
                    double value = parameterConfig.getAveragValue() + random.nextDouble() *
                            parameterConfig.getMaxDeviation() * 2 - parameterConfig.getMaxDeviation();
                    parameters.put(parameterConfig.getName(), value);
                }
                sensorData.setParameters(parameters);
                producer.send(sensorData);
            }
            currentTime = currentTime.plusSeconds((long) (config.getSamplingInterval() * 1000));
            try {
                Thread.sleep(config.getMessageInterval() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
