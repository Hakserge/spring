package com.learnspring.learnspring.services;

import com.learnspring.learnspring.models.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    List<Course> listAllCourses();
    List<Course> listCoursePerDepartmentAndSemester(String acaId,Long semesterId);
    Course getCourseById(Long code);
    void deleteCourseById(Long code);

}
