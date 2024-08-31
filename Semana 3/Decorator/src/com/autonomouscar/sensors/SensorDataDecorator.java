package com.autonomouscar.sensors;

public abstract class SensorDataDecorator implements SensorData {
    protected SensorData decoratedSensorData;

    public SensorDataDecorator(SensorData decoratedSensorData) {
        this.decoratedSensorData = decoratedSensorData;
    }
}
