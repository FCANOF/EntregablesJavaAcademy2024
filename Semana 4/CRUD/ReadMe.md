### **Sensor Management System - REST API using Spring Boot and JPA**
**Frida Cano**

*Java Backend Academy September 2024*

---

## **Overview**

This project implements a REST API for managing autonomous vehicle sensor data using Spring Boot, JPA, and MySQL. It focuses on creating, reading, updating, and deleting (CRUD) sensor data, enabling the management of various sensors like cameras, LiDAR, and radar in a self-driving car. By leveraging JPA for database interaction and Spring Boot for building the REST API, this project demonstrates how to manage sensor data in a scalable and efficient way.

## **Project Structure**

The project is organized as follows:

```plaintext
sensor-management/
├───src/
│   └───main/
│       ├───java/
│       │   └───com/
│       │       └───autonomouscar/
│       │           └───sensormanagement/
│       │               ├───controller/
│       │               │   └───SensorController.java
│       │               ├───model/
│       │               │   └───Sensor.java
│       │               ├───repository/
│       │               │   └───SensorRepository.java
│       │               └───service/
│       │                   └───SensorService.java
│       └───resources/
│           ├───application.properties
│           └───data.sql
└───pom.xml
```

### **Files Explanation**

#### **1. `Sensor.java` (Model)**

Located in the `model` package, this class represents the `Sensor` entity that corresponds to the `sensors` table in the MySQL database. It contains fields such as `id`, `sensorName`, `sensorType`, and `status`.

- **Fields**:
  - `id`: Primary key for the sensor (auto-generated).
  - `sensorName`: The name of the sensor.
  - `sensorType`: Type of sensor (Camera, LiDAR).
  - `status`: Current status of the sensor (e.g., calibrated, not_calibrated).
  

#### **2. `SensorRepository.java` (Repository)**

Located in the `repository` package, this interface extends `JpaRepository` and provides CRUD operations for the `Sensor` entity. No need to write explicit SQL queries since JPA takes care of the database interactions.

#### **3. `SensorService.java` (Service)**

Located in the `service` package, this class contains the business logic for managing sensors. It interacts with the `SensorRepository` to perform operations like finding all sensors, adding new sensors, updating sensor information, and deleting sensors.

#### **4. `SensorController.java` (Controller)**

Located in the `controller` package, this class handles HTTP requests for managing sensors. It defines API endpoints for creating, reading, updating, and deleting sensors.

- **Endpoints**:
  - `GET /all`: Retrieve all sensors.
  - `POST /create`: Add a new sensor.
  - `PUT /update/{id}`: Update an existing sensor.
  - `DELETE /delete/{id}`: Delete a sensor by ID.


#### **5. `application.properties` (Configuration)**

Located in the `resources` folder, this file contains the database configuration for connecting to the MySQL database. You need to replace `username` and `password` with your actual MySQL credentials.

```properties
spring.application.name=sensor-management
spring.datasource.url=jdbc:mysql://localhost:3306/sensor_management
spring.datasource.username=jpa_project_W4
spring.datasource.password=jpa_project_W4

server.port = 8081
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

#### **6. `data.sql` (Optional)**

This file is used to insert initial data into the `sensors` table when the application starts. You can add sample data for testing.

```sql
INSERT INTO `sensor` (`id`,`sensor_name`,`sensor_type`,`status`) VALUES (1,'multisense','camera', 'calibrated');
INSERT INTO `sensor` (`id`,`sensor_name`,`sensor_type`,`status`) VALUES (2,'velodyne','LiDAR', 'calibrated');
```

## **How to Set Up and Run the Project**

### **1. Spring Initializr Setup**

- Go to [Spring Initializr](https://start.spring.io/).
- Select **Maven Project** and **Java 17**.
- Add the following dependencies:
  - **Spring Web** (for building the REST API).
  - **Spring Data JPA** (for JPA and database integration).
  - **MySQL Driver** (for connecting to MySQL database).
  - **Lombok** (for reducing boilerplate code, optional).

### **2. MySQL Database Setup**

1. Create a database in MySQL:
   ```sql
   CREATE DATABASE sensor_management;
   USE sensor_management;
   ```

2. Add the database connection properties in `application.properties`.

### **3. Running the Project**

1. **Clone the Repository:**

   Clone the project to your local machine.

2. **Run the Application:**

   In VS code you can use the Maven Pluggin _run_.

3. **Access the API:**
   - Access `GET /all` at `http://localhost:8081/api/sensors` to retrieve the list of sensors.

## **Conclusion**

This project demonstrates how to implement a REST API for sensor data management in a self-driving vehicle scenario using Spring Boot, JPA, and MySQL. By applying the principles of RESTful design, we can create flexible and scalable services that manage sensor data in real-time. The project can be extended by adding more sensor types and implementing additional services related to autonomous vehicle operation.

## **License**

This project is open-source and can be used for educational purposes.
