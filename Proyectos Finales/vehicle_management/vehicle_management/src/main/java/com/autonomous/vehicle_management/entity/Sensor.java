package com.autonomous.vehicle_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Sensor(String sensorName, String sensorType, String status) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.status = status;
    }

}
