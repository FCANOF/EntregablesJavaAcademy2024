package com.autonomouscar.sensors;

public class RadarData implements SensorData {
    @Override
    public String getData() {
        return "Speed and distance data from radar";
    }
}