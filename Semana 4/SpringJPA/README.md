### **Sensor Management System - REST API using Spring Boot and JPA**
**Frida Cano**

*Java Backend Academy September 2024*

---

## **Overview**

The Sensor Management System is a REST API designed for managing sensor data in the context of autonomous vehicles. This system uses Spring Boot and Java 17, applying a multi-layered architecture that separates concerns between the controller, service, and repository layers. The project demonstrates the use of JPA (Java Persistence API) for data access, including a custom repository implementation. The system allows for managing sensor details such as sensor type, location, and status.

---

## **Project Structure**

The project is organized as follows:

```plaintext
sensor-management/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── autonomouscar/
│   │   │           └── sensor_management/
│   │   │               ├── controller/
│   │   │               │   └── SensorController.java
│   │   │               ├── entity/
│   │   │               │   └── Sensor.java
│   │   │               ├── repository/
│   │   │               │   ├── SensorRepositoryImpl.java
│   │   │               │   └── SensorRepositoryInterface.java
│   │   │               ├── service/
│   │   │               │   ├── SensorService.java
│   │   │               │   └── SensorServiceImpl.java
│   │   │               └── SensorManagementApplication.java
│   ├── resources/
│   │   ├── application.properties
│   │   ├── static/
│   │   └── templates/
├── .mvn/
├── test/
├── target/
└── pom.xml

```

---

### **Files Explanation**

#### **1. `Sensor.java` (Model)**

Located in the `entity` package, this class represents the `Sensor` entity that corresponds to the `sensors` table in the MySQL database. It contains fields such as `id`, `sensorName`, `sensorType`, and `status`.

- **Fields**:
  - `id`: Primary key for the sensor (auto-generated).
  - `sensorName`: The name of the sensor.
  - `sensorType`: Type of sensor (Camera, LiDAR).
  - `status`: Current status of the sensor (e.g., calibrated, not_calibrated).

#### **2. `SensorRepositoryInterface.java` (Repository)**

Located in the `repository` package, this interface provides CRUD operations for the `Sensor` entity. It defines methods such as `findAll`, `findById`, `save`, and `deleteById`.

#### **3. `SensorRepositoryImpl.java` (Repository Implementation)**

Implements the `SensorRepositoryInterface`. It uses `EntityManager` for performing database operations such as fetching all sensors, finding a sensor by ID, saving a sensor, and deleting a sensor.

#### **4. `SensorService.java` (Service)**

Located in the `service` package, this interface contains the business logic for managing sensors. It defines operations such as getting all sensors, retrieving a sensor by ID, creating a sensor, and deleting a sensor.

#### **5. `SensorServiceImpl.java` (Service Implementation)**

Implements the `SensorService` interface. It handles business logic, interacting with the `SensorRepositoryInterface` for database operations.

#### **6. `SensorController.java` (Controller)**

Located in the `controller` package, this class handles HTTP requests for managing sensors. It defines API endpoints for creating, reading, updating, and deleting sensors.

- **Endpoints**:
  - `GET /api/sensors`: Retrieve all sensors.
  - `GET /api/sensors/search/{id}`: Retrieve a specific sensor by ID.
  - `POST /api/sensors/add`: Add a new sensor.
  - `PUT /api/sensors/update/{id}`: Add a new sensor.
  - `DELETE /api/sensors/delete/{id}`: Delete a sensor by ID.

#### **7. `application.properties` (Configuration)**

Located in the `resources` folder, this file contains the database configuration for connecting to the MySQL database. You need to replace `username` and `password` with your actual MySQL credentials.

```properties
spring.application.name=sensor-management
spring.datasource.url=jdbc:mysql://localhost:3306/sensor_management
spring.datasource.username=jpa_project_W4
spring.datasource.password=jpa_project_W4

server.port = 8082
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

#### **8. `data.sql` (Optional)**

This file is used to insert initial data into the `sensor` table when the application starts. You can add sample data for testing.

```sql
INSERT INTO `sensor` (`id`,`sensor_name`,`sensor_type`,`status`) VALUES (1,'multisense','camera', 'calibrated');
INSERT INTO `sensor` (`id`,`sensor_name`,`sensor_type`,`status`) VALUES (2,'velodyne','LiDAR', 'calibrated');
```

---

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

   In VS Code, you can use the Maven plugin to run the project.

3. **Access the API:**

   Access the following endpoints:
   - **GET** `/api/sensors`: Retrieve all sensors.
   - **GET** `/api/sensors/{id}`: Retrieve a sensor by ID.

---

## **Conclusion**

This project demonstrates how to implement a REST API for sensor data management in a self-driving vehicle scenario using Spring Boot, JPA, and MySQL. By applying the principles of RESTful design, we can create flexible and scalable services that manage sensor data in real-time. The project can be extended by adding more sensor types and implementing additional services related to autonomous vehicle operation.

---

## **License**

This project is open-source and can be used for educational purposes.
