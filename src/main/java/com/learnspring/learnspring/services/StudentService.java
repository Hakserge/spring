package com.learnspring.learnspring.services;

import com.learnspring.learnspring.models.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);
    List<Student> listAllStudent();
    void deleteStudent(Long id);
    Student updateStudent(Long id);
}
