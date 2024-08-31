package com.autonomouscar.sensors;

public class CameraData implements SensorData {
    @Override
    public String getData() {
        return "Raw image data from camera";
    }
}