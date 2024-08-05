package com.StudentSubjectManagent.Service.ServiceImpl;

import com.StudentSubjectManagent.Entity.Student;
import com.StudentSubjectManagent.Entity.Subject;
import com.StudentSubjectManagent.ExceptionHandler.ResourceNotFound;
import com.StudentSubjectManagent.Repository.StudentRepository;
import com.StudentSubjectManagent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository repo;
    @Override
    public Student saveStudentData(Student student) {
        String studentId = UUID.randomUUID().toString();
        student.setStudentId(studentId);
        Set<Subject> subjects = student.getSubjects();
        // id is assigns only if set of subjects is not empty.
        if(subjects!=null)
        {
            for(Subject s : subjects)
            {
                String id = UUID.randomUUID().toString();
                s.setSubjectId(id);
            }
        }

        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudentsList()
    {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(String studentId) {
        Student student = repo.findById(studentId).orElseThrow(() -> new ResourceNotFound("Student not found for given id"));
        return student;
    }
}

