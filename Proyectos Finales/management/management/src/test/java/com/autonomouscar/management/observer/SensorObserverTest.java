package com.autonomouscar.management.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// JUnit 5 test class for the SensorObserver pattern
class SensorObserverTest {

    private Sensor sensor;
    private NavigationSystem navigationSystem;
    private ControlSystem controlSystem;

    @BeforeEach
    void setUp() {
        // Initialize the sensor and the systems
        sensor = new Sensor("1", "Camera");
        navigationSystem = new NavigationSystem();
        controlSystem = new ControlSystem();

        // Register observers
        sensor.registerObserver(navigationSystem);
        sensor.registerObserver(controlSystem);
    }

    @Test
    void testSensorStatusChange_NotifiesObservers() {
        // Simulate sensor going offline
        sensor.setStatus(false);

        navigationSystem.update(sensor);
        controlSystem.update(sensor);

        // Assert that the NavigationSystem received the update
        assertTrue(navigationSystem.isUpdated(sensor),
            "Navigation system should be updated when the sensor goes offline.");
        
        // Assert that the ControlSystem received the update
        assertTrue(controlSystem.isUpdated(sensor),
            "Control system should be updated when the sensor goes offline.");
    }

    @Test
    void testSensorStatusChange_NoNotificationWithoutObservers() {
        // Unregister observers
        sensor.removeObserver(navigationSystem);
        sensor.removeObserver(controlSystem);

        // Reset observer update flags
        navigationSystem.resetUpdate(sensor);
        controlSystem.resetUpdate(sensor);

        // Simulate sensor going offline
        sensor.setStatus(false);

        // Assert that the NavigationSystem did not receive the update
        assertFalse(navigationSystem.isUpdated(sensor),
            "Navigation system should not be updated after being unregistered.");
        
        // Assert that the ControlSystem did not receive the update
        assertFalse(controlSystem.isUpdated(sensor),
            "Control system should not be updated after being unregistered.");
    }
}
