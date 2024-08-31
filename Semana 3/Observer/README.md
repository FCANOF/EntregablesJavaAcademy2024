# **Vision System - Observer Design Pattern**
**Frida Cano**  
*Java Backend Academy August 2024*

## **Overview**

This project demonstrates the application of the Observer design pattern in a Java 17 project focused on sensor data monitoring in a self-driving car's perception system. The Observer pattern is a behavioral design pattern that allows an object (the subject) to notify multiple dependent objects (observers) about state changes without tightly coupling them. This pattern is particularly useful in scenarios where real-time updates are critical, such as in the various systems of a self-driving car that need to react to sensor data immediately.

## **Project Structure**

The project is organized into the following files and directories:

```plaintext
Observer/
├── src/
│   └── com/
│       └── autonomouscar/
│           └── sensors/
│               ├── Subject.java
│               ├── Observer.java
│               ├── CameraSensor.java
│               ├── LiDARSensor.java
│               ├── ObstacleDetectionSystem.java
│               ├── LaneTrackingSystem.java
│               ├── TrafficSignRecognitionSystem.java
│               └── VisionSystem.java
└── Observer.pdf
```

### **Files**

- **`Subject.java`**
  - **Description:** Defines the interface for subjects (observables) in the Observer pattern.
  - **Functionality:** Declares methods for attaching, detaching, and notifying observers. This interface is implemented by sensor classes to manage their observers.

- **`Observer.java`**
  - **Description:** Defines the interface for observers in the Observer pattern.
  - **Functionality:** Declares the `update()` method, which is called by the subject to notify observers of any changes in the data.

- **`CameraSensor.java`**
  - **Description:** A concrete implementation of the `Subject` interface.
  - **Functionality:** Manages a list of observers and notifies them whenever the camera sensor data changes.

- **`LiDARSensor.java`**
  - **Description:** Another concrete implementation of the `Subject` interface.
  - **Functionality:** Similar to `CameraSensor`, but handles data from a LiDAR sensor and notifies its observers of any changes.

- **`ObstacleDetectionSystem.java`**
  - **Description:** A concrete implementation of the `Observer` interface.
  - **Functionality:** Receives and processes updates from sensors to detect obstacles in the vehicle's surroundings.

- **`LaneTrackingSystem.java`**
  - **Description:** A concrete implementation of the `Observer` interface.
  - **Functionality:** Receives and processes updates from sensors to track lanes on the road.

- **`TrafficSignRecognitionSystem.java`**
  - **Description:** A concrete implementation of the `Observer` interface.
  - **Functionality:** Receives and processes updates from sensors to recognize traffic signs.

- **`VisionSystem.java`**
  - **Description:** The main class that ties everything together, simulating the interaction between sensors and their observers.
  - **Functionality:** Demonstrates how different sensor systems can be monitored and updated using the Observer pattern. It shows how the system reacts to new sensor data by notifying the appropriate observers.

- **`Observer.pdf`**
  - **Description:** A detailed report explaining the implementation of the Observer design pattern in this project.
  - **Content:** The report includes an introduction to the Observer pattern, a description of the project, code implementation details, and explanations of design choices.

## **Getting Started**

### **Prerequisites**
- **Java 17:** Ensure that Java 17 is installed on your system.
- **Java IDE:** Use an IDE such as Visual Studio Code, IntelliJ IDEA, or Eclipse for easier development and execution.
- **JUnit 5:** Required for running the unit tests. Ensure JUnit 5 is set up in your development environment.

### **How to Run**

1. **Clone the Repository:**
   - Clone the project repository to your local machine using Git

2. **Compile the Code:**
   - Navigate to the `src` directory:
     ```bash
     cd Observer/src
     ```
   - Compile the Java files:
     ```bash
     javac com/autonomouscar/sensors/*.java
     ```

3. **Run the Main Class:**
   - Execute the `VisionSystem` class to simulate the observer pattern in action:
     ```bash
     java com.autonomouscar.sensors.VisionSystem
     ```
   - **Expected Output:**
     ```
     Obstacle Detection System received data: New camera image data
     Lane Tracking System received data: New camera image data
     Obstacle Detection System received data: New LiDAR depth data
     Traffic Sign Recognition System received data: New LiDAR depth data
     ```

## **Project Documentation**

For a comprehensive explanation of the project, including the design patterns, code implementation, and testing strategies, please refer to the `Observer.pdf` document included in the project repository.

## **License**

This project is open-source and available for educational purposes. Feel free to modify and expand upon it as needed.