package com.autonomouscar.sensors;

public class ObstacleDetectionSystem implements Observer {

    @Override
    public void update(String data) {
        System.out.println("Obstacle Detection System received data: " + data);
        // Process the data to detect obstacles
    }
}
