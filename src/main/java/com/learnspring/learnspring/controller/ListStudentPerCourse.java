package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.Course;
import com.learnspring.learnspring.models.CourseDefinition;
import com.learnspring.learnspring.models.StudentCourse;
import com.learnspring.learnspring.services.CourseDefinitionService;
import com.learnspring.learnspring.services.CourseService;
import com.learnspring.learnspring.services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListStudentPerCourse {
    @Autowired
    CourseDefinitionService courseDefinitionService;
    @Autowired
    StudentCourseService studentCourseService;
    @GetMapping("/studentPerCourse")
    public String studentPerCourse(Model module){
        List<CourseDefinition> courseDefinitionList=courseDefinitionService.listAllCourses();
        module.addAttribute("courseDefList",courseDefinitionList);
        return "stdPerCourse";
    }
    @GetMapping("/listStudentPerCourse")
    public String listStudentPerCourse(
            @RequestParam("courseDefId") String courseDefId, Model model){
        List<StudentCourse> studentCoursesList=studentCourseService.listStudentPerCourse(courseDefId);
        List<CourseDefinition> courseDefinitionList=courseDefinitionService.listAllCourses();
       model.addAttribute("courseDefList",courseDefinitionList);
       model.addAttribute("courseList",studentCoursesList);
       return "stdPerCourse";
    }

}
