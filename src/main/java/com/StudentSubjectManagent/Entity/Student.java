package com.StudentSubjectManagent.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="students")
public class Student {

    @Id
    @Column(name="student_id",nullable = false)
    private String studentId;
    @NotNull
    private String name;
    @NotNull
    private String address;

    @ManyToMany
    @JoinTable(name="students_subjects", joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="subject_id"))
    private Set<Subject> subjects = new HashSet<>();
}