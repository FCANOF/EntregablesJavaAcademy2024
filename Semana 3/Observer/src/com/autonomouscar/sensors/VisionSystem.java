package com.autonomouscar.sensors;

public class VisionSystem {
    public static void main(String[] args) {
        System.out.println("Initializing Vision System");
        // Create sensor subjects
        CameraSensor cameraSensor = new CameraSensor();
        LiDARSensor lidarSensor = new LiDARSensor();

        // Create observer systems
        ObstacleDetectionSystem obstacleDetection = new ObstacleDetectionSystem();
        LaneTrackingSystem laneTracking = new LaneTrackingSystem();
        TrafficSignRecognitionSystem trafficSignRecognition = new TrafficSignRecognitionSystem();

        // Attach observers to sensors
        cameraSensor.attach(obstacleDetection);
        cameraSensor.attach(laneTracking);
        lidarSensor.attach(obstacleDetection);
        lidarSensor.attach(trafficSignRecognition);

        // Simulate sensor data updates
        cameraSensor.setData("New camera image data");
        lidarSensor.setData("New LiDAR depth data");
    }
}
