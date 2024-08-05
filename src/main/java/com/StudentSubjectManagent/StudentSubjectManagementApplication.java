package com.StudentSubjectManagent;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(title = "Student Management Application APIs",
				version = "1.0.0",
				description = "It is a Student Management application apis documentation"),
		servers=@Server(url = "http://localhost:8080",
				description = "Student and Subject managing APIs")

)
@SpringBootApplication
public class StudentSubjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSubjectManagementApplication.class, args);
	}

}
