package com.autonomous.vehicle_management.config;

import com.autonomous.vehicle_management.entity.BatteryCharge;

import org.springframework.batch.item.ItemProcessor;

public class BatteryChargeProcessor implements ItemProcessor<BatteryCharge, BatteryCharge> {

    @Override
    public BatteryCharge process(BatteryCharge chargeHistory) throws Exception {
        if ("Failed".equals(chargeHistory.getChargeStatus())) {
            chargeHistory.setIssueDetected(true);
        } else {
            chargeHistory.setIssueDetected(false);
        }
        return chargeHistory;
    }
}
