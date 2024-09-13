package com.autonomous.vehicle_management.controller;

import com.autonomous.vehicle_management.entity.Sensor;
import com.autonomous.vehicle_management.service.SensorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping()
    public String index() {
        return "Welcome to the Sensor Management System!";
    }

    @GetMapping("/all")
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

    @GetMapping("/oneSensor/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable int id) {
        return ResponseEntity.ok(sensorService.getSensorById(id));
    }

    @PostMapping("/add")
    public String createSensor(@RequestBody Sensor sensor) {
        sensorService.createSensor(sensor);
        return "Sensor created successfully!";
    }

    @PutMapping("/update/{id}")
    public String updateSensor(@PathVariable int id, @RequestBody Sensor sensorDetails) {
        sensorService.updateSensor(id, sensorDetails);
        return "Sensor updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSensor(@PathVariable int id) {
        sensorService.deleteSensor(id);
        ResponseEntity.noContent().build();
        return "Sensor deleted successfully!";
    }

}
