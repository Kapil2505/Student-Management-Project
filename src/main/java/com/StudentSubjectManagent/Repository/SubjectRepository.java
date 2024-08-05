package com.StudentSubjectManagent.Repository;

import com.StudentSubjectManagent.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,String> {
}