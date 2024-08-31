# **Sensor Data Fusion - Decorator Design Pattern**
**Frida Cano**  
*Java Backend Academy August 2024*

## **Overview**

This project implements the Decorator design pattern in a Java 17 application, simulating sensor data fusion for the perception system of an autonomous car. The project showcases how the Decorator pattern can be used to dynamically add responsibilities to objects, enabling flexible and modular combination of data from multiple sensors.

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
│               ├── CameraData.java
│               ├── LiDARData.java
│               ├── RadarData.java
│               ├── EnhancedCameraData.java
│               ├── FusedData.java
│               ├── VisionSystem.java
│               └── SensorDataTest.java
└── Decorator.pdf
```

### **Files**

- **`SensorData.java`**
  - **Description:** An interface representing the data produced by a sensor.
  - **Functionality:** Defines the `getData()` method, which returns sensor data as a string.

- **`SensorDataDecorator.java`**
  - **Description:** An abstract class implementing the `SensorData` interface.
  - **Functionality:** Serves as the base decorator class, holding a reference to a `SensorData` object and delegating the `getData()` method to the wrapped object. It allows for the dynamic addition of responsibilities to `SensorData` objects.

- **`CameraData.java`**
  - **Description:** A concrete class implementing the `SensorData` interface, representing a camera sensor.
  - **Functionality:** Returns simulated camera data via the `getData()` method, e.g., "Raw image data from camera".

- **`LiDARData.java`**
  - **Description:** A concrete class implementing the `SensorData` interface, representing a LiDAR sensor.
  - **Functionality:** Returns simulated LiDAR data via the `getData()` method, e.g., "Distance and depth data from LiDAR".

- **`RadarData.java`**
  - **Description:** A concrete class implementing the `SensorData` interface, representing a radar sensor.
  - **Functionality:** Returns simulated radar data via the `getData()` method, e.g., "Speed and distance data from radar".

- **`EnhancedCameraData.java`**
  - **Description:** A concrete decorator class extending `SensorDataDecorator`.
  - **Functionality:** Enhances camera data by adding functionalities such as object recognition. Overrides the `getData()` method to append additional information, e.g., "Raw image data from camera with object recognition".

- **`FusedData.java`**
  - **Description:** A concrete decorator class extending `SensorDataDecorator`.
  - **Functionality:** Combines data from multiple sensors to provide fused information. Overrides the `getData()` method to integrate data, e.g., "Fused Data: Raw image data from camera with object recognition".

- **`VisionSystem.java`**
  - **Description:** The main class demonstrating how to use the Decorator pattern for sensor data fusion.
  - **Functionality:** Initializes sensor objects, applies decorators to enhance and fuse the data, and outputs the combined sensor information to the console.

- **`SensorDataTest.java`**
  - **Description:** Contains unit tests using JUnit 5 to validate the functionality of the sensor data fusion.
  - **Functionality:** Tests individual sensor classes and the fusion of data using decorators to ensure correct behavior.

- **`Decorator.pdf`**
  - **Description:** A detailed report explaining the implementation of the Decorator design pattern in this project.
  - **Content:** Includes an introduction to the Decorator pattern, a description of the project, code implementation details, and explanations of design choices.

## **Getting Started**

### **Prerequisites**
- **Java 17:** Ensure that Java 17 is installed on your system.
- **Java IDE:** Use an IDE such as Visual Studio Code, IntelliJ IDEA, or Eclipse for easier development and execution.
- **JUnit 5:** Required for running the unit tests. Ensure JUnit 5 is set up in your development environment.

### **How to Run**

1. **Clone the Repository:**
   - Clone the project repository to your local machine using Git:
     ```bash
     git clone https://github.com/yourusername/Decorator.git
     ```
     *(Replace the URL with the actual repository URL if applicable.)*

2. **Compile the Code:**
   - Navigate to the `src` directory:
     ```bash
     cd Decorator/src
     ```
   - Compile the Java files:
     ```bash
     javac com/autonomouscar/sensors/*.java
     ```

3. **Run the Main Class:**
   - Execute the `VisionSystem` class to simulate sensor data fusion:
     ```bash
     java com.autonomouscar.sensors.VisionSystem
     ```
   - **Expected Output:**
     ```
     Camera Data: Raw image data from camera with object recognition
     LiDAR Data: Fused Data: Distance and depth data from LiDAR
     Radar Data: Fused Data: Speed and distance data from radar
     ```
     *(The actual output may vary based on implementation details.)*

4. **Run Tests:**
   - Ensure JUnit 5 is available in your classpath.
   - Execute the unit tests using your IDE’s built-in test runner or via command line:
     ```bash
     java -jar junit-platform-console-standalone-1.8.1.jar --class-path . --scan-class-path
     ```
     *(Adjust the command based on your environment and JUnit setup.)*

## **Project Documentation**

For a comprehensive explanation of the project, including the design patterns, code implementation, and testing strategies, please refer to the `Decorator.pdf` document included in the project repository.

## **License**

This project is open-source and available for educational purposes. Feel free to modify and expand upon it as needed.
