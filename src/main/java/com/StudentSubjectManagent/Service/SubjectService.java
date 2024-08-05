package com.StudentSubjectManagent.Service;

import com.StudentSubjectManagent.Entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject saveSubject(Subject subject);

    List<Subject> getAllSubject();
}

