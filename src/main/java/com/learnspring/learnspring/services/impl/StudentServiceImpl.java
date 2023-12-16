package com.learnspring.learnspring.services.impl;

import com.learnspring.learnspring.models.Student;
import com.learnspring.learnspring.repository.StudentRepository;
import com.learnspring.learnspring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Autowired
    private StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository =studentRepository;
    }
    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public List<Student> listAllStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id) {
        Optional<Student>optional=studentRepository.findById(id);
        Student student=null;
        if (optional.isPresent()){
            student=optional.get();
        }else {
            throw new RuntimeException("student id not found"+id);
        }
        return student;
    }
}
