package com.autonomouscar.sensor_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Getter
    @Setter
    private int id;

    @Column(name="sensor_name")
    @Getter
    @Setter
    private String sensorName;

    @Column(name="sensor_type")
    @Getter
    @Setter
    private String sensorType;

    @Column(name="status")
    @Getter
    @Setter
    private String status;

    public Sensor() {
    }

    public Sensor(String sensorName, String sensorType, String status) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.status = status;
    }
}