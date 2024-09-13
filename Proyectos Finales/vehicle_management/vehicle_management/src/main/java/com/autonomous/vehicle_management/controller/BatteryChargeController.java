package com.autonomous.vehicle_management.controller;

import com.autonomous.vehicle_management.entity.BatteryCharge;
import com.autonomous.vehicle_management.service.BatteryChargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteryCharge")
public class BatteryChargeController {

    @Autowired
    private BatteryChargeService batteryChargeService;
    
    @GetMapping()
    public String index() {
        return "Welcome to the Battery Charge Management System!";
    }

    @GetMapping("/all")
    public List<BatteryCharge> getAllBatteryCharges() {
        return batteryChargeService.getAllBatteryCharges();
    }

    @GetMapping("/oneBatteryCharge/{id}")
    public ResponseEntity<BatteryCharge> getBatteryChargeById(@PathVariable Long id) {
        return ResponseEntity.ok(batteryChargeService.getBatteryChargeById(id));
    }

    @PostMapping("/add")
    public BatteryCharge createBatteryCharge(@RequestBody BatteryCharge batteryCharge) {
        return batteryChargeService.createBatteryCharge(batteryCharge);
    }

    @PutMapping("/update/{id}")
    public BatteryCharge updateBatteryCharge(@PathVariable Long id, @RequestBody BatteryCharge batteryChargeDetails) {
        return batteryChargeService.updateBatteryCharge(id, batteryChargeDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBatteryCharge(@PathVariable Long id) {
        batteryChargeService.deleteBatteryCharge(id);
    }

}
