package com.example.TestProjectOne.repository;

import com.example.TestProjectOne.dto.SensorData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository extends CrudRepository<SensorData, Long> {
}
