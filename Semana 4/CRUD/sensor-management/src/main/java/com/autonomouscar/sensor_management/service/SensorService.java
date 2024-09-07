package com.autonomouscar.sensor_management.service;

import com.autonomouscar.sensor_management.model.Sensor;
import com.autonomouscar.sensor_management.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sensor not found"));
    }

    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor updateSensor(Long id, Sensor sensorDetails) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sensor not found"));
        sensor.setSensorName(sensorDetails.getSensorName());
        sensor.setSensorType(sensorDetails.getSensorType());
        sensor.setStatus(sensorDetails.getStatus());
        return sensorRepository.save(sensor);
    }

    public void deleteSensor(Long id) {
        sensorRepository.deleteById(id);
    }
}