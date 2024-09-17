# Self-Driving Vehicle Management System
**Frida Cano**

*Java Backend Academy September 2024*

---

## Overview

The **Self-Driving Vehicle Management System** is designed to monitor and manage key components of autonomous vehicles, focusing on two main modules:
1. **Sensor Monitoring**: This module handles the tracking and status of various sensors in the vehicle, ensuring proper functionality.
2. **Battery Charge History Tracking**: This module manages the battery charging data, including the tracking of charge start and end times, charging areas, charger identification, and any issues detected during the charging process.

The system is developed using Java 17 and leverages several Spring Framework technologies, including Spring Boot, Spring Data JPA, and Spring Batch for managing data processing, persistence, and CSV import/export. Additionally, the system implements the Object-Oriented Programming (OOP) principles, with a focus on design patterns such as CRUD operations and testing with Mockito to ensure reliability.

---

## Project Structure

```
vehicle_management/
│
├── config/
│   ├── BatteryChargeJobConfig.java
│   ├── BatteryChargeProcessor.java
│
├── controller/
│   ├── BatteryChargeController.java
│
├── service/
│   ├── BatteryChargeService.java
│
├── repository/
│   ├── BatteryChargeRepository.java
│   ├── SensorRepository.java
│
├── model/
│   ├── BatteryCharge.java
│   ├── Sensor.java
│
├── resources/
│   ├── application.properties
│   ├── battery_charge_data.CSV
│   ├── table_setup.sql
│
└── test/
    ├── BatteryCharge_MockitoTest.java
```

---

## Key Features

### 1. **Battery Charge Management**
The system tracks battery charge operations for self-driving vehicles, including:
- Battery ID and charger ID.
- Charge start and end times.
- Subsystem area responsible for the charge.
- Detection of any issues during the charging process.

### 2. **Sensor Monitoring**
- Tracks different types of sensors used in self-driving vehicles.
- Monitors sensor status, allowing for real-time monitoring and troubleshooting.

### 3. **Data Import/Export**
- Implements **Spring Batch** to import and export battery charge history from/to a CSV file.
- The CSV files store critical information such as battery ID, charge times, and detected issues.

---

## Technologies Used

- **Java 17**: The latest version of Java was chosen for its modern language features and performance optimizations.
- **Spring Boot**: Provides rapid application development and simplifies dependency management.
- **Spring Data JPA**: Manages the persistence of battery charge and sensor data to a relational database.
- **Spring Batch**: Handles bulk data import/export, especially for handling battery charge history in CSV format.
- **JUnit 5 & Mockito**: Used for unit testing the application, particularly for testing the controller and service layers with mocked objects.
- **MySQL**: Used as the relational database for managing sensor and battery charge data.

---

## Database Setup

Run the following SQL script to set up the database:

```sql
-- 1. Create the database
create database if not exists vehicle_management;

-- 2. Use the newly created database
USE vehicle_management;

-- 3. Create the table for Battery Charge History
drop table if exists sensor;
drop table if exists battery_charge;

CREATE TABLE `battery_charge` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `battery_id` VARCHAR(50) NOT NULL,
    `charge_start_time` VARCHAR(100),
    `charge_end_time` VARCHAR(100),
    `charging_area` VARCHAR(100),
    `charger_id` VARCHAR(50) NOT NULL,
    `charge_status` VARCHAR(30) NOT NULL,
    `issue_detected` BOOLEAN DEFAULT FALSE,
    `issue_description` VARCHAR(255)
);

CREATE TABLE `sensor` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `sensor_name` VARCHAR(255) DEFAULT NULL,
    `sensor_type` VARCHAR(255) DEFAULT NULL,
    `status` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```

---

## How to Run the Project

1. **Clone the repository:**
    ```bash
    git clone https://github.com/FCANOF/EntregablesJavaAcademy2024/tree/main/Proyectos%20Finales 
    cd vehicle-management-system
    ```

2. **Configure MySQL:**
    Ensure that your MySQL server is running and create the database by executing the provided SQL script.

3. **Install Dependencies:**
    Make sure you have Maven installed. Run the following command to download all necessary dependencies:
    ```bash
    mvn clean install
    ```

4. **Run the Application:**
    After setting up the database, run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

5. **Access the Application:**
    The application will be accessible at `http://localhost:8080`.

---

## Testing

Mockito and JUnit 5 were used to test the application. To run the tests:

```bash
mvn test
```

The test coverage for key components such as the `BatteryChargeController` reaches **95.45%**, ensuring that the critical parts of the system are well-tested and reliable.

---

## Future Improvements

- **Enhance Error Handling**: Improve the error detection and reporting for sensor failures and battery charge issues.
- **Real-Time Monitoring**: Implement WebSocket or other real-time technologies for live monitoring of sensor statuses.
- **Data Analytics**: Add analytical modules to analyze trends in battery charge performance and sensor reliability.

---

## Contributors

- Frida Cano - frida_canofal@outlook.com

---

## License

This project is licensed under the MIT License.
