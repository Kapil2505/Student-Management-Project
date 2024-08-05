package com.StudentSubjectManagent.Repository;

import com.StudentSubjectManagent.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
