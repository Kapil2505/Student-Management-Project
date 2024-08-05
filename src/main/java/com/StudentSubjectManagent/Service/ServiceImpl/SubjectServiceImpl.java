package com.StudentSubjectManagent.Service.ServiceImpl;

import com.StudentSubjectManagent.Entity.Subject;
import com.StudentSubjectManagent.Repository.SubjectRepository;
import com.StudentSubjectManagent.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;
    @Override
    public Subject saveSubject(Subject subject) {
        String id = UUID.randomUUID().toString();
        subject.setSubjectId(id);
        return repository.save(subject);
    }

    @Override
    public List<Subject> getAllSubject() {
        return repository.findAll();
    }
}

