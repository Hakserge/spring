package com.learnspring.learnspring.services.impl;

import com.learnspring.learnspring.models.Course;
import com.learnspring.learnspring.repository.CourseRepository;
import com.learnspring.learnspring.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }
    @Override
    public void saveCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public List<Course> listAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public List<Course> listCoursePerDepartmentAndSemester( String acaId,Long semesterId) {
        return this.courseRepository.listCoursePerDepartmentAndSemester(acaId,semesterId);
    }

    @Override
    public Course getCourseById(Long code) {
        Optional<Course> optional=courseRepository.findById(code);
        Course course=null;
        if (optional.isPresent()){
            course=optional.get();
        }else {
            throw new RuntimeException("the course id not found"+code);
        }
        return course;
    }

    @Override
    public void deleteCourseById(Long code) {
        this.courseRepository.deleteById(code);

    }


}
