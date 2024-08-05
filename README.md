Introduction
This project is a Spring Boot application that provides a REST API to manage students and subjects. Students can enroll in multiple subjects. The application includes security features with JWT-based authentication and role-based access control for student and admin roles. An in-memory H2 database is used for ease of setup and testing.

Features
Manage students and subjects.
Enroll students in multiple subjects.
JWT-based authentication.
Role-based access control.
In-memory H2 database for testing.
RESTful API endpoints for CRUD operations.

Technologies Used
Java 19
Spring Boot
Spring MVC
Spring Data JPA
Spring Security
JWT
H2 Database

Setup Instructions
Prerequisites
Ensure you have the following installed:
JDK 19 or later
Maven
Git

Clone the Repository

Configure the Application
Update src/main/resources/application.properties if needed. For example, to change the server port or database configurations.
server.port=8080
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect


Run the Application

Access the Application
The application will be available at http://localhost:8080.
Access the H2 database console at http://localhost:8080/h2-console.
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave it blank)


Endpoints

Authentication
POST /Registration: http://localhost:8080/authApi/SignUp
POST/Authentication: http://localhost:8080/authApi/SignIn

Students
POST /api/students: http://localhost:8080/api/student/saveStudent
GET /api/students: http://localhost:8080/api/student/getStudentById/{studentId}
GET /api/students/{studentId}/enroll: http://localhost:8080/api/student/getAllDetails

Subjects
POST /api/subjects: http://localhost:8080/api/subject/saveSubject
GET /api/subjects: http://localhost:8080/api/subject/getAllDetails


Security
Roles: Add below data to your User_Role table manually
ROLE_STUDENT
ROLE_ADMIN


JWT:
Add the JWT token in the Authorization header as Bearer <token> for authenticated requests.

Swagger Documentation:
http://localhost:8080/swagger-ui/index.html  using this url you can see the Api documentation.

Use postman or swagger ui to test APIs.
If H2 Database is not working then add another database
so add that database dependancy in pom.xml file
add data configuration code in application.properties file 
