package com.autonomouscar.sensor_management.controller;

import com.autonomouscar.sensor_management.entity.Sensor;
import com.autonomouscar.sensor_management.service.SensorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private SensorService sensorService;

    @Autowired
    public SensorController(SensorService TheSensorService) {
        sensorService = TheSensorService;
    }

    @GetMapping()
    public String home() {
        return "Welcome to the Sensor Management API without Data JPA!";
    }

    @GetMapping("/all")
    public List<Sensor> findAll() {
        return sensorService.findAll();
    }

    @GetMapping("/search/{id}")
    public Sensor findById(@PathVariable int id) {
        return sensorService.findById(id);
    }

    @PostMapping("/add")
    public Sensor addSensor(@RequestBody Sensor sensor) {
        sensor.setId(0);
        return sensorService.save(sensor);
    }

    @PutMapping("/update/{id}")
    public Sensor updateSensor(@RequestBody Sensor sensor) {
        return sensorService.save(sensor);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSensor(@PathVariable int id) {
        sensorService.deleteById(id);
        return "Sensor with id " + id + " has been deleted.";
    }

}
