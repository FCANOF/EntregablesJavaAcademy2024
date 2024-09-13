package com.autonomouscar.management.decorator;

public class BatteryChargeDecorator implements BatteryCharge {
    protected BatteryCharge decoratedBatteryCharge;

    public BatteryChargeDecorator(BatteryCharge batteryCharge) {
        this.decoratedBatteryCharge = batteryCharge;
    }

    @Override
    public void charge() {
        decoratedBatteryCharge.charge();
    }

    @Override
    public String getDetails() {
        return decoratedBatteryCharge.getDetails();
    }
}