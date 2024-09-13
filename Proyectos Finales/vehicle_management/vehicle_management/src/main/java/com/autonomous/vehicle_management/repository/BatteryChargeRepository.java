package com.autonomous.vehicle_management.repository;

import com.autonomous.vehicle_management.entity.BatteryCharge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryChargeRepository extends JpaRepository<BatteryCharge, Long> {

}
