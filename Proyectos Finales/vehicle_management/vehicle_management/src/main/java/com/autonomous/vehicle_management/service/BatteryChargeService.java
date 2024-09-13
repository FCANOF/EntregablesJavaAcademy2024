package com.autonomous.vehicle_management.service;


import com.autonomous.vehicle_management.entity.BatteryCharge;
import com.autonomous.vehicle_management.repository.BatteryChargeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryChargeService {
    
        @Autowired
        private BatteryChargeRepository batteryChargeRepository;
    
        public List<BatteryCharge> getAllBatteryCharges() {
            return batteryChargeRepository.findAll();
        }
    
        public BatteryCharge getBatteryChargeById(Long id) {
            return batteryChargeRepository.findById(id).orElseThrow(() -> new RuntimeException("BatteryCharge not found"));
        }
    
        public BatteryCharge createBatteryCharge(BatteryCharge batteryCharge) {
            return batteryChargeRepository.save(batteryCharge);
        }
    
        public BatteryCharge updateBatteryCharge(Long id, BatteryCharge batteryChargeDetails) {
            BatteryCharge batteryCharge = batteryChargeRepository.findById(id).orElseThrow(() -> new RuntimeException("BatteryCharge not found"));
            batteryCharge.setChargeStatus(batteryChargeDetails.getChargeStatus());
            batteryCharge.setChargeStartTime(batteryChargeDetails.getChargeStartTime());
            batteryCharge.setChargeEndTime(batteryChargeDetails.getChargeEndTime());
            batteryCharge.setChargingArea(batteryChargeDetails.getChargingArea());
            batteryCharge.setChargerId(batteryChargeDetails.getChargerId());
            batteryCharge.setIssueDetected(batteryChargeDetails.getIssueDetected());
            batteryCharge.setIssueDescription(batteryChargeDetails.getIssueDescription());
            return batteryChargeRepository.save(batteryCharge);
        }
    
        public void deleteBatteryCharge(Long id) {
            batteryChargeRepository.deleteById(id);
        }
}
