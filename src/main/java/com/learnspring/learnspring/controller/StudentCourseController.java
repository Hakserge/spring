package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.Course;
import com.learnspring.learnspring.models.StudentCourse;
import com.learnspring.learnspring.models.StudentRegistration;
import com.learnspring.learnspring.services.CourseService;
import com.learnspring.learnspring.services.StudentCourseService;
import com.learnspring.learnspring.services.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @Autowired
    private StudentRegistrationService studentRegistrationService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/showNewStudentCourseForm")
    public String showStudentCourse(Model model){
        StudentCourse studentCourse =new StudentCourse();
        List<StudentRegistration> studentRegistrations = studentRegistrationService.listAllStudentRegistration();
        List<Course> courseList = courseService.listAllCourses();
        model.addAttribute("studentCourse", studentCourse);
        model.addAttribute("studentRegistrationList", studentRegistrations);
        model.addAttribute("courseList", courseList);
        return "studentCourse";
    }

    @PostMapping("/saveStudentCourse")
    public String saveStudentCourse(@ModelAttribute("studentCourse") StudentCourse studentCourse){
        studentCourseService.saveStudentCourse(studentCourse);
        return "redirect:/showNewStudentCourseForm";
    }

    @GetMapping("/studentCourseDashBoard")
    public String showAllStudentCourse(Model model){
        List<StudentCourse> studentCourses = studentCourseService.listAStudentCourse();
        model.addAttribute("studentCourseList", studentCourses);
        return "studentCourseDashBoard";
    }
    @GetMapping("/updateStudentCourse/{id}")
    public String updateStudentCourse(@PathVariable(value = "id")Long id, Model model){
        StudentCourse studentCourse=studentCourseService.getStudentCourseById(id);
        List<StudentRegistration> studentRegistrations = studentRegistrationService.listAllStudentRegistration();
        List<Course> courseList = courseService.listAllCourses();
        model.addAttribute("studentRegistrationList", studentRegistrations);
        model.addAttribute("courseList", courseList);
        model.addAttribute(studentCourse);
        return "updateStudentCourse";

    }
    @GetMapping("/deleteStudentCourse/{id}")
    public String updateStudentCourse(@PathVariable(value = "id")Long id){
        this.studentCourseService.deleteStudentCourse(id);
        return "redirect:/studentCourseDashBoard";
    }
}
