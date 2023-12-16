package com.learnspring.learnspring.services;

import com.learnspring.learnspring.models.Course;
import com.learnspring.learnspring.models.CourseDefinition;
import com.learnspring.learnspring.models.StudentCourse;

import java.util.List;

public interface StudentCourseService {
    void saveStudentCourse(StudentCourse studentCourse);
    List<StudentCourse> listAStudentCourse();
    List<StudentCourse> listStudentPerCourseAndSemester(String course, Long semester);
    List<StudentCourse> listStudentPerCourse(String courseId);
    StudentCourse getStudentCourseById(Long id);
    void deleteStudentCourse(Long id);
}
