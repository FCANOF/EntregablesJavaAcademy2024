package com.autonomouscar.sensors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SensorDataTest {

    @Test
    public void testCameraData() {
        SensorData cameraData = new CameraData();
        assertEquals("Raw image data from camera", cameraData.getData());
    }

    @Test
    public void testEnhancedCameraData() {
        SensorData cameraData = new CameraData();
        SensorData enhancedCameraData = new EnhancedCameraData(cameraData);
        assertEquals("Raw image data from camera with object recognition", enhancedCameraData.getData());
    }

    @Test
    public void testFusedCameraData() {
        SensorData cameraData = new CameraData();
        SensorData enhancedCameraData = new EnhancedCameraData(cameraData);
        SensorData fusedCameraData = new FusedData(enhancedCameraData);

        assertEquals("Fused Data: Raw image data from camera with object recognition", fusedCameraData.getData());
    }

    @Test
    public void testFusedLiDARData() {
        SensorData lidarData = new LiDARData();
        SensorData fusedLidarData = new FusedData(lidarData);

        assertEquals("Fused Data: Distance and depth data from LiDAR", fusedLidarData.getData());
    }

    @Test
    public void testFusedRadarData() {
        SensorData radarData = new RadarData();
        SensorData fusedRadarData = new FusedData(radarData);

        assertEquals("Fused Data: Speed and distance data from radar", fusedRadarData.getData());
    }
}
