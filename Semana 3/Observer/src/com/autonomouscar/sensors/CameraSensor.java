package com.autonomouscar.sensors;

import java.util.ArrayList;
import java.util.List;

public class CameraSensor implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String data;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(data);
        }
    }

    public void setData(String data) {
        this.data = data;
        notifyObservers();
    }
}
