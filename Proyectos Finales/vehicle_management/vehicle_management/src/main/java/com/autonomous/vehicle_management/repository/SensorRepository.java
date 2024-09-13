package com.autonomous.vehicle_management.repository;

import com.autonomous.vehicle_management.entity.Sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

}
