package com.autonomouscar.management.decorator;

public class FaultyBatteryChargeDecorator extends BatteryChargeDecorator {

    public FaultyBatteryChargeDecorator(BatteryCharge batteryCharge) {
        super(batteryCharge);
    }

    @Override
    public void charge() {
        super.charge();
        System.out.println("FaultyBatteryChargeDecorator: Checking for potential faults...");
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " Warning: Charger malfunction detected.";
    }
}