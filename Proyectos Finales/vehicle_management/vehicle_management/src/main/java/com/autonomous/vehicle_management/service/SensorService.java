package com.autonomous.vehicle_management.service;

import com.autonomous.vehicle_management.entity.Sensor;
import com.autonomous.vehicle_management.repository.SensorRepository;

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

    public Sensor getSensorById(int id) {
        return sensorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sensor not found"));
    }

    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor updateSensor(int id, Sensor sensorDetails) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sensor not found"));
        sensor.setSensorName(sensorDetails.getSensorName());
        sensor.setSensorType(sensorDetails.getSensorType());
        sensor.setStatus(sensorDetails.getStatus());
        return sensorRepository.save(sensor);
    }

    public void deleteSensor(int id) {
        sensorRepository.deleteById(id);
    }
}
