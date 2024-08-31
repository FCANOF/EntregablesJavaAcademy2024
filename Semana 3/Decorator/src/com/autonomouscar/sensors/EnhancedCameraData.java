package com.autonomouscar.sensors;

public class EnhancedCameraData extends SensorDataDecorator {

    public EnhancedCameraData(SensorData decoratedSensorData) {
        super(decoratedSensorData);
    }

    @Override
    public String getData() {
        return decoratedSensorData.getData() + " with object recognition";
    }
}
