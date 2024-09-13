package com.autonomouscar.battery_management.repository;

import com.autonomouscar.battery_management.entity.BatteryChargeHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BatteryRepository extends JpaRepository<BatteryChargeHistory, Long> {

    // // Custom query method to find all battery charge histories with issues
    // List<BatteryChargeHistory> findByIssueDetectedTrue();
}