# employee-management-api
A RESTful API for Employee Management built with Java Spring Boot. It supports CRUD operations for managing employee records, using Spring Data JPA and MySQL/H2 database. Perfect for learning and demonstrating backend development practices. It includes features such as employee creation, retrieval by ID or all employees, updating employee details, and deleting employee records.

The project uses MySQL as the database to store employee information, and Spring Data JPA for easy data management with the ORM layer. Additionally, the project follows best practices in API development, ensuring maintainability, scalability, and security.

# Key Features:
Create Employee: Allows for the creation of new employee records.
Retrieve Employees: Supports retrieving a list of all employees or searching by employee ID.
Update Employee: Enables the modification of existing employee data.
Delete Employee: Allows for removing an employee from the system.

# Technologies Used:
Spring Boot: Framework for building and deploying the API.
Spring Data JPA: ORM tool for easy interaction with the MySQL database.
MySQL: Relational database for storing employee data.
JUnit: Testing framework for unit and integration tests.
Mockito: Mocking framework to simulate service layer for unit testing.
Postman: Used for manual API testing with JSON payloads.

# Testing Practices:
Unit Testing:

The service layer is unit-tested using JUnit and Mockito. Mocking dependencies like the EmployeeRepository allows for isolated testing of business logic.
Unit tests focus on ensuring that CRUD operations (create, read, update, and delete) work as expected, and edge cases are handled properly.
Integration Testing:

Integration tests are performed to ensure the system works end-to-end with the real database and that data flows correctly between the API and the MySQL database.
Spring Boot Test annotations are used to create an embedded server for testing the API endpoints.
API Testing:

Postman is used to manually test API endpoints with different payloads, checking for proper status codes and response data formats.

# Project Structure:
Entity Layer: Defines the Employee class representing the employee data model with attributes like firstName, lastName, email, and team.
Service Layer: Handles the business logic for CRUD operations.
Repository Layer: Uses Spring Data JPA to interact with the database.
Controller Layer: Exposes REST API endpoints for client interaction.
