package com.autonomouscar.management.observer;

public class ControlSystem implements SensorObserver {

    private boolean updated = false;

    @Override
    public void update(Sensor sensor) {
        if (!sensor.getStatus()) {
            System.out.println("NavigationSystem: Sensor " + sensor.getId() + " is offline. Re-routing the vehicle...");
        }else {
            System.out.println("NavigationSystem: Sensor " + sensor.getId() + " is online. Vehicle is on course.");
        }
        updated = true;
    }

    public boolean isUpdated(Sensor sensor) {
        return updated;
    }

    public void resetUpdate(Sensor sensor) {
        updated = false;
    }
}