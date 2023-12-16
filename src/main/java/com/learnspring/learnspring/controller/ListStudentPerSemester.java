package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.Semester;
import com.learnspring.learnspring.models.StudentRegistration;
import com.learnspring.learnspring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListStudentPerSemester {
    @Autowired
    private StudentRegistrationService studentRegistrationService;

    @Autowired
    private SemesterService semesterService;

    @GetMapping("/listStudentPerSemester")
    public String list(Model model) {
        List<Semester> semesterList = semesterService.listAllSemester();
        model.addAttribute("semesterList", semesterList);
        return "stdPerSemester";
    }

    @GetMapping("/studentsBySemester")
    public String listStudentsBySemester(@RequestParam(value = "semesterId") Long semesterId, Model model) {
        List<StudentRegistration> students = studentRegistrationService.listStudentsBySemester(semesterId);
        List<Semester> semesterList = semesterService.listAllSemester();
        model.addAttribute("students", students);
        model.addAttribute("semesterList", semesterList);
        return "stdPerSemester"; // Assuming your Thymeleaf template is named "listStudentPerSemester.html"
    }
}
