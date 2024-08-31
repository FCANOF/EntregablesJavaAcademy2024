package com.autonomouscar.sensors;

public class LaneTrackingSystem implements Observer {

    @Override
    public void update(String data) {
        System.out.println("Lane Tracking System received data: " + data);
        // Process the data to track lanes
    }
}
