package com.learnspring.learnspring.services;


import com.learnspring.learnspring.models.CourseDefinition;
import com.learnspring.learnspring.models.Teacher;

import java.util.List;

public interface CourseDefinitionService {
    void saveCourseDefinition(CourseDefinition courseDefinition);
    List<CourseDefinition> listAllCourses();
    CourseDefinition getCourseDefinitionById(String code);
    void deleteCourseDefinitionById(String code);
}
