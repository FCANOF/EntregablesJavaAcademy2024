package com.autonomouscar.sensors;

public class LiDARData implements SensorData {
    @Override
    public String getData() {
        return "Distance and depth data from LiDAR";
    }
}