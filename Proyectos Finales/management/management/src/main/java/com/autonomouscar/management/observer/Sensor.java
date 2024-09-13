package com.autonomouscar.management.observer;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements SensorSubject {
    private String id;
    private String type;
    private boolean status; // True if active, False if offline
    private List<SensorObserver> observers;

    public Sensor(String id, String type) {
        this.id = id;
        this.type = type;
        this.status = true;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(SensorObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(SensorObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (SensorObserver observer : observers) {
            observer.update(this);
        }
    }

    // Method to simulate status change of the sensor
    public void setStatus(boolean status) {
        this.status = status;
        notifyObservers();
    }

    public boolean getStatus() {
        return status;
    }

    // Getters for sensor properties
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
