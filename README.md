1.Introduction: 

This project is a Spring Boot application that provides a REST API to manage students and subjects. Students can enroll in multiple subjects. The application includes security features with JWT-based authentication and role-based access control for student and admin roles. An in-memory H2 database is used for ease of setup and testing.

2.Features:

1.Manage students and subjects.
2.Enroll students in multiple subjects.
3.JWT-based authentication.
4.Role-based access control.
5.In-memory H2 database for testing.
6.RESTful API endpoints for CRUD operations.

3.Technologies Used:

1.Java 19
2.Spring Boot
3.Spring MVC
4.Spring Data JPA
5.Spring Security
6.JWT
7.H2 Database
8.Swagger Documentation

4.Setup Instructions:

Prerequisites:

Ensure you have the following installed:
1.JDK 19 or later
2.Maven
3.Git

5.Clone the Repository : https://github.com/Kapil2505/Student-Management-Project.git

6.Configure the Application

Update src/main/resources/application.properties if needed. For example, to change the server port or database configurations.
server.port=8080
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect


7.Run the Application

8.Access the Application:

The application will be available at http://localhost:8080.
Access the H2 database console at http://localhost:8080/h2-console.
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave it blank)


9.Endpoints:

1.Authentication:
POST /Registration: http://localhost:8080/authApi/SignUp
POST/Authentication: http://localhost:8080/authApi/SignIn

2.Students:
POST /api/students: http://localhost:8080/api/student/saveStudent
GET /api/students: http://localhost:8080/api/student/getStudentById/{studentId}
GET /api/students/{studentId}/enroll: http://localhost:8080/api/student/getAllDetails

3.Subjects:
POST /api/subjects: http://localhost:8080/api/subject/saveSubject
GET /api/subjects: http://localhost:8080/api/subject/getAllDetails


10.Security:
Roles: Add below data to your User_Role table manually
ROLE_STUDENT
ROLE_ADMIN


11.JWT:

Add the JWT token in the Authorization header as Bearer <token> for authenticated requests.

12.Swagger Documentation:

http://localhost:8080/swagger-ui/index.html  using this url you can see the Api documentation.

13.Use postman or swagger ui to test APIs.

14.If H2 Database is not working then add another database
so add that database dependancy in pom.xml file
add data configuration code in application.properties file 
