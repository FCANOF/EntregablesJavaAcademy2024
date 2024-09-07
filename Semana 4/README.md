# Week 4
**Frida Cano**

*Java Backend Academy September 2024*

---

This repository contains four Java 17 projects, each focusing on a specific technology or framework. These projects demonstrate how to work with Spring JPA, Spring Data JPA, Spring Batch, and Mockito in a real-world context. Below is a brief overview of each project.

## 1. **Spring JPA**

### Overview
The **Spring JPA** project demonstrates how to use Java Persistence API (JPA) with Spring Boot to create a CRUD application. The project focuses on persisting data to a relational database and managing it through a REST API.

### Key Features
- **CRUD Operations**: Create, read, update, and delete records in a database.
- **Entity Mapping**: Mapping Java objects to relational database tables.
- **Repository Layer**: Using `JpaRepository` for basic CRUD methods.
- **Transaction Management**: Using JPA annotations for transaction control.

### Technologies
- **Java 17**
- **Spring Boot**
- **JPA (Java Persistence API)**
- **MySQL**

### How to Run
1. Clone the repository.
2. Configure database settings in `application.properties`.
3. Run the application using `mvn spring-boot:run`.
4. Access the REST endpoints for CRUD operations.

---

## 2. **Spring Data JPA**

### Overview
The **Spring Data JPA** project enhances the JPA project by leveraging the powerful features of Spring Data. It simplifies data access by reducing boilerplate code and adding custom query capabilities.

### Key Features
- **Spring Data Repositories**: Extend `CrudRepository` or `JpaRepository` for easy data management.
- **Custom Queries**: Use `@Query` annotations and method-based queries.
- **Pagination and Sorting**: Implement pagination and sorting for large datasets.

### Technologies
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**

### How to Run
1. Clone the repository.
2. Configure the H2 in-memory database settings.
3. Run the application using `mvn spring-boot:run`.
4. Test the API using Postman or curl to interact with the database.

---

## 3. **Spring Batch**

### Overview
The **Spring Batch** project demonstrates batch processing using Spring Batch. It processes large volumes of data by reading, processing, and writing data in chunks. The project simulates a simple ETL (Extract, Transform, Load) process.

### Key Features
- **Job Configuration**: Define jobs, steps, and flows.
- **Item Readers/Writers**: Read and write data from different sources.
- **Batch Processing**: Process data in chunks for performance optimization.
- **Retry and Skip Logic**: Handle errors during batch processing.

### Technologies
- **Java 17**
- **Spring Boot**
- **Spring Batch**
- **CSV File Processing**

### How to Run
1. Clone the repository.
2. Place the input data files in the correct directory.
3. Run the application using `mvn spring-boot:run`.
4. The batch job will automatically start and process the data.

---

## 4. **Mockito**

### Overview
The **Mockito** project is designed to demonstrate unit testing in Java using the Mockito framework. The project includes examples of mocking dependencies to test service-layer logic without involving actual database calls or external systems.

### Key Features
- **Mocking Dependencies**: Create mocks for service dependencies.
- **JUnit 5 Integration**: Write unit tests with Mockito and JUnit 5.
- **Behavior Verification**: Verify method calls on mocks to ensure correct interactions.
- **Stubbing Methods**: Define return values for mocked methods.

### Technologies
- **Java 17**
- **Mockito**
- **JUnit 5**

### How to Run
1. Clone the repository.
2. Run the test cases using the `mvn test` command.
3. View the test results in the terminal or IDE.

---

## Conclusion

These four projects demonstrate key Java and Spring-related frameworks and libraries, highlighting best practices for developing scalable, maintainable applications. Each project is structured to focus on a specific framework, providing a solid foundation for further development.

--- 
