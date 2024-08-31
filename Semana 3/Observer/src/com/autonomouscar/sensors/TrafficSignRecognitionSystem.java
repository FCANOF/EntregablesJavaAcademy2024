package com.autonomouscar.sensors;

public class TrafficSignRecognitionSystem implements Observer {

    @Override
    public void update(String data) {
        System.out.println("Traffic Sign Recognition System received data: " + data);
        // Process the data to recognize traffic signs
    }
}
