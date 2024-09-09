package com.autonomouscar.battery_management.config;

import com.autonomouscar.battery_management.entity.BatteryChargeHistory;

import org.springframework.batch.item.ItemProcessor;

public class BatteryChargeProcessor implements ItemProcessor<BatteryChargeHistory, BatteryChargeHistory> {

    @Override
    public BatteryChargeHistory process(BatteryChargeHistory chargeHistory) throws Exception {
        if ("Failed".equals(chargeHistory.getChargeStatus())) {
            chargeHistory.setIssueDetected(true);
        } else {
            chargeHistory.setIssueDetected(false);
        }
        return chargeHistory;
    }
}
