package com.learnspring.learnspring.services.impl;

import com.learnspring.learnspring.models.Course;
import com.learnspring.learnspring.models.CourseDefinition;
import com.learnspring.learnspring.models.StudentCourse;
import com.learnspring.learnspring.repository.StudentCourseRepository;
import com.learnspring.learnspring.services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    StudentCourseRepository studentCourseRepository;
    @Autowired
    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository){
        this.studentCourseRepository=studentCourseRepository;
    }
    @Override
    public void saveStudentCourse(StudentCourse studentCourse) {
        this.studentCourseRepository.save(studentCourse);
    }

    @Override
    public List<StudentCourse> listAStudentCourse() {
        return this.studentCourseRepository.findAll();
    }

    @Override
    public List<StudentCourse> listStudentPerCourseAndSemester(String course, Long semester) {
        return this.studentCourseRepository.listStudentPerCourseAndSemester(course,semester);
    }

    @Override
    public List<StudentCourse> listStudentPerCourse(String courseId) {
        return this.studentCourseRepository.listStudentPerCourse(courseId);
    }

    @Override
    public StudentCourse getStudentCourseById(Long id) {
        Optional<StudentCourse> optional=studentCourseRepository.findById(id);
        StudentCourse studentCourse=null;
        if(optional.isPresent()){
            studentCourse=optional.get();

        }else {
            throw new RuntimeException("studentCourse Id not found"+id);
        }
        return studentCourse;
    }


    @Override
    public void deleteStudentCourse(Long id) {
        this.studentCourseRepository.deleteById(id);
    }


}
