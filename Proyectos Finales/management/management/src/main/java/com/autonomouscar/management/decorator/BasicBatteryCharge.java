package com.autonomouscar.management.decorator;

public class BasicBatteryCharge implements BatteryCharge {

    @Override
    public void charge() {
        System.out.println("BasicBatteryCharge: Charging the battery...");
    }

    @Override
    public String getDetails() {
        return "Battery charging... Basic charge.";
    }
}
