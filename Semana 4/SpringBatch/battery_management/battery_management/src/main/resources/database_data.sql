-- 1. Create the database
create database if not exists battery_management;

-- 2. Use the newly created database
USE battery_management;

-- 3. Create the table for Battery Charge History
drop table if exists battery_charge_history;

CREATE TABLE `battery_charge_history` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `battery_id` VARCHAR(50) NOT NULL,   -- Battery ID to identify the battery being charged
    `charge_start_time` VARCHAR(100),  -- Time when the battery started charging
    `charge_end_time` VARCHAR(100),    -- Time when the battery finished charging
    `charging_area` VARCHAR(100),         -- Which subsystem connected the battery
    `charger_id` VARCHAR(50) NOT NULL, -- Charger ID to identify wich of two chargers was used
    `charge_status` VARCHAR(30) NOT NULL,    -- Status of the charge (e.g., 'successful', 'failed')
    `issue_detected` BOOLEAN DEFAULT FALSE,  -- Flag to detect any issue during charging (e.g., true if there was an issue)
    `issue_description` VARCHAR(255)                -- Optional description of the issue if one was detected
);

-- 4. Insert sample data for testing
INSERT INTO `battery_charge_history` (id, battery_id, charge_start_time, charge_end_time, charging_area, charger_id, charge_status, issue_detected, issue_description)
VALUES (1, 'A', '2024-09-09 10:00:00', '2024-09-09 11:00:00', 'Software', 'A','successful', FALSE, NULL);

INSERT INTO `battery_charge_history` (id, battery_id, charge_start_time, charge_end_time, charging_area, charger_id, charge_status, issue_detected, issue_description)
VALUES (2, 'B', '2024-09-09 12:00:00', '2024-09-09 13:00:00', 'Electronics', 'B','failed', TRUE, 'Charger malfunction during operation.');
