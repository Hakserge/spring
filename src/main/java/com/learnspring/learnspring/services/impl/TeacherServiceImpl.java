package com.learnspring.learnspring.services.impl;

import com.learnspring.learnspring.models.Teacher;
import com.learnspring.learnspring.repository.TeacherRepository;
import com.learnspring.learnspring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository){

        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findByAllTeacher() {

        return teacherRepository.findAll();
    }

    @Override
    public void SaveTeacher(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Optional<Teacher> optional=teacherRepository.findById(id);
        Teacher teacher=null;
        if (optional.isPresent()){
            teacher=optional.get();
        }else {
            throw new RuntimeException("teacher id not found "+id);
        }
        return teacher;
    }

    @Override
    public void deleteTeacherById(Long id) {
    this.teacherRepository.deleteById(id);
    }
}
