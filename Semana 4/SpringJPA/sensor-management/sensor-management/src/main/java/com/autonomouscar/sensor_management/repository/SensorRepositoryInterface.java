package com.autonomouscar.sensor_management.repository;

import com.autonomouscar.sensor_management.entity.Sensor; 

import java.util.List;

public interface SensorRepositoryInterface {

    List<Sensor> findAll();

    Sensor findById(int id);

    Sensor save(Sensor sensor);

    void deleteById(int id);

}
