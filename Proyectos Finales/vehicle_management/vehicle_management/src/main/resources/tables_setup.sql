-- 1. Create the database
create database if not exists vehicle_management;

-- 2. Use the newly created database
USE vehicle_management;

-- 3. Create the table for Battery Charge History
drop table if exists sensor;
drop table if exists battery_charge;

CREATE TABLE `battery_charge` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `battery_id` VARCHAR(50) NOT NULL,   -- Battery ID to identify the battery being charged
    `charge_start_time` VARCHAR(100),  -- Time when the battery started charging
    `charge_end_time` VARCHAR(100),    -- Time when the battery finished chargingbattery_charge_history
    `charging_area` VARCHAR(100),         -- Which subsystem connected the battery
    `charger_id` VARCHAR(50) NOT NULL, -- Charger ID to identify wich of two chargers was used
    `charge_status` VARCHAR(30) NOT NULL,    -- Status of the charge (e.g., 'successful', 'failed')
    `issue_detected` BOOLEAN DEFAULT FALSE,  -- Flag to detect any issue during charging (e.g., true if there was an issue)
    `issue_description` VARCHAR(255)                -- Optional description of the issue if one was detected
);

CREATE TABLE `sensor` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `sensor_name` VARCHAR(255) DEFAULT NULL,
    `sensor_type` VARCHAR(255) DEFAULT NULL,
    `status` VARCHAR(255) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
