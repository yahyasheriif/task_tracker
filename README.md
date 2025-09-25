# Task Tracker Application

This is a Spring Boot-based Task Tracker application. It provides RESTful APIs for user authentication and managing tasks.

## Features

- User Authentication (Login, Registration)
- JWT-based Security
- Task Management (Create, Read, Update, Delete tasks)
- PostgreSQL Database Integration

## Technologies Used

- Java 24
- Spring Boot
- Spring Data JPA
- Spring Security
- JJWT (JSON Web Tokens)
- PostgreSQL
- Lombok

## Project Structure

- `src/main/java/com/yahya/task_tracker/`: Main application source code.
  - `config/`: Security configurations, including JWT filter.
  - `controller/`: REST controllers for authentication and task operations.
  - `entity/`: JPA entities (`Task`, `User`).
  - `repository/`: Spring Data JPA repositories for data access.
  - `service/`: Business logic for tasks and users.
- `src/main/resources/application.properties`: Application configuration.
- `pom.xml`: Maven project object model, defining dependencies and build process.

## Getting Started

### Prerequisites

- Java 24 Development Kit (JDK)
- Maven
- PostgreSQL database instance

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yahyasheriif/task_tracker.git
   cd task_tracker/Task_Tracker
   ```

2. Configure your PostgreSQL database in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build the application using Maven:
   ```bash
   mvn clean install
   ```

### Running the Application

```bash
java -jar target/Task_Tracker-0.0.1-SNAPSHOT.jar
```
Or, you can run it directly from your IDE as a Spring Boot application.



