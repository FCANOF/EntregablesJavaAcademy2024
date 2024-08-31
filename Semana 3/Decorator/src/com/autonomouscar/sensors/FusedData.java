package com.autonomouscar.sensors;

public class FusedData extends SensorDataDecorator {

    public FusedData(SensorData decoratedSensorData) {
        super(decoratedSensorData);
    }

    @Override
    public String getData() {
        // Assume this method combines data from multiple sources if needed.
        return "Fused Data: " + decoratedSensorData.getData();
    }
}
