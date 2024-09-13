package com.autonomouscar.management.decorator;

public class EfficientBatteryChargeDecorator extends BatteryChargeDecorator {

    public EfficientBatteryChargeDecorator(BatteryCharge batteryCharge) {
        super(batteryCharge);
    }

    @Override
    public void charge() {
        super.charge();
        System.out.println("EfficientBatteryChargeDecorator: Optimizing battery charging...");
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " Adding efficiency improvements.";
    }
}