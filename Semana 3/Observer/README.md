# **Sensor Data Fusion - Decorator Design Pattern**
**Frida Cano**  
*Java Backend Academy August 2024*

## **Overview**

This project implements the Decorator design pattern in a Java 17 application, simulating sensor data fusion for the perception system of an autonomous car. The project demonstrates how the Decorator pattern can be used to dynamically add responsibilities to objects, allowing for the flexible combination of data from multiple sensors.

## **Project Structure**

The project is organized into the following files and directories:

```plaintext
Decorator/
├── src/
│   └── com/
│       └── autonomouscar/
│           └── sensors/
│               ├── SensorData.java
│               ├── SensorDataDecorator.java
│               ├── FusedData.java
│               ├── CameraSensor.java
│               ├── LiDARSensor.java
│               ├── VisionSystem.java
│               └── SensorDataTest.java
└── Decorator.pdf
```

### **Files**

- **`SensorData.java`**
  - An interface representing the data produced by a sensor. 
  - Defines the `getData()` method, which returns sensor data as a string.

- **`SensorDataDecorator.java`**
  - An abstract class implementing the `SensorData` interface.
  - Serves as the base decorator class, holding a reference to a `SensorData` object and delegating the `getData()` method.

- **`FusedData.java`**
  - Extends `SensorDataDecorator` to combine data from two different sensors.
  - Implements the `getData()` method to return a string that fuses data from the original sensor and an additional sensor.

- **`CameraSensor.java`**
  - A concrete class implementing the `SensorData` interface, representing a camera sensor.
  - Returns simulated camera data via the `getData()` method.

- **`LiDARSensor.java`**
  - Another concrete class implementing the `SensorData` interface, representing a LiDAR sensor.
  - Returns simulated LiDAR data via the `getData()` method.

- **`VisionSystem.java`**
  - The main class demonstrating how to use the Decorator pattern for sensor data fusion.
  - It initializes the sensor objects, applies decorators to fuse the data, and outputs the fused data.

- **`SensorDataTest.java`**
  - Contains unit tests using JUnit 5 to validate the functionality of the sensor data fusion.
  - Tests the individual sensor classes and the fusion of data using decorators.

- **`Decorator.pdf`**
  - A detailed report explaining the implementation of the Decorator design pattern in this project.
  - The report includes an introduction to the Decorator pattern, a description of the project, and the full code implementation with explanations.

## **Getting Started**

### **Prerequisites**
- Java 17 installed on your system.
- A Java IDE (such as Visual Studio Code) or a command-line environment for compiling and running the code.
- JUnit 5 for running the tests.

### **How to Run**

1. **Clone the Repository:**
   - Clone the project repository to your local machine.

2. **Compile the Code:**
   - Navigate to the `src` directory in your terminal or IDE.
   - Run the following command to compile the Java files:
     ```bash
     javac com/autonomouscar/sensors/*.java
     ```

3. **Run the Main Class:**
   - Execute the `VisionSystem` class to run the sensor data fusion simulation:
     ```bash
     java com.autonomouscar.sensors.VisionSystem
     ```

4. **Run Tests:**
   - Run the JUnit tests to ensure everything is functioning correctly:
     ```bash
     java -cp .:junit-platform-console-standalone-1.8.1.jar org.junit.platform.console.ConsoleLauncher --select-class com.autonomouscar.sensors.SensorDataTest
     ```

## **Project Documentation**

For a detailed explanation of the project, including the code and design choices, please refer to the `Decorator.pdf` document included in the project.

## **License**

This project is open-source and available for educational purposes. Feel free to modify and expand upon it as needed.
