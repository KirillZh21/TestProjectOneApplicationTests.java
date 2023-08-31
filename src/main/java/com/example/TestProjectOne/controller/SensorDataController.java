package com.example.TestProjectOne.controller;

import com.example.TestProjectOne.dto.SensorData;
import com.example.TestProjectOne.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sensor-data")
public class SensorDataController {
    private SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorDataController(SensorDataRepository sensorDataRepository){
        this.sensorDataRepository = sensorDataRepository;
    }

    @PostMapping
    public SensorData create(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }

    @GetMapping
    public Iterable<SensorData> findAll(){
        return sensorDataRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SensorData> findById(@PathVariable Long id) {
        return sensorDataRepository.findById(id);
    }


}
