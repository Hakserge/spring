package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.*;
import com.learnspring.learnspring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
@Autowired
    AcademicUnitService academicUnitService;
@Autowired
    SemesterService semesterService;
@Autowired
    TeacherService teacherService;
@Autowired
    CourseDefinitionService courseDefinitionService;
@GetMapping("/showNewCourseForm")
public String showCourseForm(Model model){
    List<AcademicUnit> academicUnits=academicUnitService.listAllAcademicUnit();
    List<Semester> semesters=semesterService.listAllSemester();
    List<Teacher>teachers=teacherService.findByAllTeacher();
    List<CourseDefinition>courseDefinitions=courseDefinitionService.listAllCourses();
    Course course= new Course();
    model.addAttribute("teachersList",teachers);
    model.addAttribute("semesterList",semesters);
    model.addAttribute("academicUnitList",academicUnits);
    model.addAttribute("courseDefinitionList",courseDefinitions);
    model.addAttribute("course",course);
    return "course";
}
@PostMapping("/saveCourse")
public String saveCourse(@ModelAttribute("course")Course course){
    courseService.saveCourse(course);
    return "redirect:/showNewCourseForm";
}
@GetMapping("/courseDashBoard")
    public String showAllCourse(Model model){
    List<Course>courseList=courseService.listAllCourses();
    model.addAttribute("courseList",courseList);
    return "courseDashBoard";
}
    @GetMapping("/updateCourse/{id}")
    public String updateCourse(@PathVariable(value = "id")Long code, Model model){
    Course course=courseService.getCourseById(code);
        List<AcademicUnit> academicUnits=academicUnitService.listAllAcademicUnit();
        List<Semester> semesters=semesterService.listAllSemester();
        List<Teacher>teachers=teacherService.findByAllTeacher();
        List<CourseDefinition>courseDefinitions=courseDefinitionService.listAllCourses();
        model.addAttribute("teachersList",teachers);
        model.addAttribute("semesterList",semesters);
        model.addAttribute("academicUnitList",academicUnits);
        model.addAttribute("courseDefinitionList",courseDefinitions);
        model.addAttribute(course);
        return "updateCourse";
    }
    @GetMapping("/deleteCourse/{id}")
    public String updateCourse(@PathVariable(value = "id")Long code){
    this.courseService.deleteCourseById(code);
    return "redirect:/courseDashBoard";
    }
}
