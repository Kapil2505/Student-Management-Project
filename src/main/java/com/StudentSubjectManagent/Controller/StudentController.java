package com.StudentSubjectManagent.Controller;

import com.StudentSubjectManagent.Entity.Student;
import com.StudentSubjectManagent.Service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@Tag(name="StudentController",description = "Its a Student Controller class")
public class StudentController {

    @Autowired
    private StudentService service;

    @PreAuthorize("hasRole('STUDENT')")
    @Operation(summary = "this API is for saving student details. This is accessing by STUDENT only")
    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student)
    {
        Student student1 = service.saveStudentData(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "this API is for getting all students record .This is accessing by ADMIN only")
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<Student>>getAllStudents()
    {
        return new ResponseEntity<>(service.getAllStudentsList(),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('STUDENT','ADMIN')")
    @Operation(summary = "this API is for getting single student record using studentId. This is accessing by both ADMIN and STUDENT")
    @GetMapping("getStudentById/{studentId}")
    public ResponseEntity<Student>getStudentDetailsById(@PathVariable String studentId)
    {
        Student student = service.getStudentById(studentId);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
}

