package com.autonomouscar.sensor_management.service;

import java.util.List;

import com.autonomouscar.sensor_management.entity.Sensor;

public interface SensorService {

    List<Sensor> findAll();

    Sensor findById(int id);

    Sensor save(Sensor sensor);

    void deleteById(int id);


}
