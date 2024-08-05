package com.StudentSubjectManagent.Controller;

import com.StudentSubjectManagent.Entity.Subject;
import com.StudentSubjectManagent.Service.SubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
@Tag(name="SubjectController")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "this API is for saving subject details. accessing by only ADMIN")
    @PostMapping("/saveSubject")
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject)
    {
        Subject subject1 = service.saveSubject(subject);
        return new ResponseEntity<>(subject1, HttpStatus.CREATED);
    }

    @Operation(summary = "this API is for getting SUBJECT records. This is accessing by both ADMIN and STUDENT")
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<Subject>>getAllStudents()
    {
        return new ResponseEntity<>(service.getAllSubject(),HttpStatus.OK);
    }

}

