# **Vision System - Builder Design Pattern**
**Frida Cano**
*Java Backend Academy August 2024*

## **Overview**

This project implements the Builder design pattern in a Java 17 application, simulating an image processing pipeline for an autonomous car's vision system. The project showcases how the Builder pattern can be used to construct complex objects step by step, allowing for flexible and modular design.

## **Project Structure**

The project is organized into the following files and directories:

```plaintext
Builder/
├── src/
│   └── com/
│       └── autonomouscar/
│           └── vision/
│               ├── ImageProcessingStage.java
│               ├── ImageProcessingPipelineBuilder.java
│               ├── ImageProcessingPipeline.java
│               └── VisionSystem.java
└── Builder.pdf
```

### **Files**

- **`ImageProcessingStage.java`**
  - Represents a single stage of the image processing pipeline.
  - Contains attributes like `stageName` and `parameters` to define the specifics of each stage.

- **`ImageProcessingPipelineBuilder.java`**
  - This is the core of the Builder pattern implementation.
  - Allows for the addition of various stages to the pipeline using the `addStage()` method.
  - The `build()` method finalizes the pipeline construction and returns an `ImageProcessingPipeline` object.

- **`ImageProcessingPipeline.java`**
  - Holds and manages the list of stages added to the pipeline.
  - Provides an `execute()` method to run all stages in sequence, simulating the processing of visual data in an autonomous vehicle.

- **`VisionSystem.java`**
  - The main class that demonstrates how to use the `ImageProcessingPipelineBuilder` to create and execute an image processing pipeline.
  - This class serves as the entry point for running the application.

- **`Builder.pdf`**
  - A detailed report explaining the implementation of the Builder design pattern in this project.
  - The report includes an introduction to the Builder pattern, a description of the project, and the full code implementation with explanations.

## **Getting Started**

### **Prerequisites**
- Java 17 installed on your system.
- A Java IDE (I used Visual Studio Code) or command-line environment for compiling and running the code.

### **How to Run**

1. **Clone the Repository:**
   - Clone the project repository to your local machine.

2. **Compile the Code:**
   - Navigate to the `src` directory in your terminal or IDE.
   - Run the following command to compile the Java files:
     ```bash
     javac com/autonomouscar/vision/*.java
     ```

3. **Run the Main Class:**
   - Execute the `VisionSystem` class to run the image processing pipeline simulation:
     ```bash
     java com.autonomouscar.vision.VisionSystem
     ```

## **Project Documentation**

For a detailed explanation of the project, including the code and design choices, please refer to the `Builder.pdf` document included in the project.

## **License**

This project is open-source and available for educational purposes. Feel free to modify and expand upon it as needed.
