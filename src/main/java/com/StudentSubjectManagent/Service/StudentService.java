package com.StudentSubjectManagent.Service;

import com.StudentSubjectManagent.Entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudentData(Student student);
    public List<Student> getAllStudentsList();

    Student getStudentById(String studentId);
}
