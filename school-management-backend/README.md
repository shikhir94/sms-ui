# School Management Backend

This is the Spring Boot backend for the School Management System, providing REST APIs for managing classes, teachers, and timetables.

## Features

- Manage classes, teachers, and timetable entries
- RESTful APIs with CORS support for frontend integration
- H2 in-memory database for development
- JPA/Hibernate for ORM

## Running the Application

1. Ensure you have Java 17 and Maven installed.
2. Navigate to the project directory: `cd school-management-backend`
3. Run: `mvn spring-boot:run`
4. The server will start on `http://localhost:8080`
5. H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)

## API Endpoints

- **Classes**: `/api/classes`
- **Teachers**: `/api/teachers`
- **Timetable**: `/api/timetable`

## Frontend Integration

The backend is configured to allow requests from `http://localhost:3000` (React frontend).