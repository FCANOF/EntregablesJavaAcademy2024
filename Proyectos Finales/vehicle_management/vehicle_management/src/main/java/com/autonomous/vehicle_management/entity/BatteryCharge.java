package com.autonomous.vehicle_management.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "battery_charge")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatteryCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "battery_id")
    @Getter
    @Setter
    private String batteryId;

    @Column(name = "charge_start_time")
    @Getter
    @Setter
    private String chargeStartTime;

    @Column(name = "charge_end_time")
    @Getter
    @Setter
    private String chargeEndTime;

    @Column(name = "charging_area")
    @Getter
    @Setter
    private String chargingArea; // Which subsystem connected the battery
    
    @Column(name = "charger_id")
    @Getter
    @Setter
    private String chargerId; // Which subsystem connected the battery

    @Column(name = "charge_status")
    @Getter
    @Setter
    private String chargeStatus; // e.g., Charged, Failed

    @Column(name = "issue_detected")
    @Getter
    @Setter
    private Boolean issueDetected; // True if there is an issue with battery/charger
    
    @Column(name = "issue_description")
    @Getter
    @Setter
    private String issueDescription;
}
