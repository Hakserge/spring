package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.Semester;
import com.learnspring.learnspring.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    @GetMapping("/ShowNewSemesterForm")
    public String ShowNewSemesterForm (Model model){
        Semester semester= new Semester();
        model.addAttribute("semester",semester);
        return "semester";
    }
    @PostMapping("/saveSemesters")
    public String saveSemester(@ModelAttribute("semester") Semester semester){
        semesterService.SaveSemester(semester);
        return "redirect:/ShowNewSemesterForm";
    }
    @GetMapping("/semesterDashBoard")
    public String showAllSemester(Model model){
        List<Semester> semesters=semesterService.listAllSemester();
        model.addAttribute("allsemester",semesters);
        return "semesterDashBoard";
    }
    @GetMapping("/deleteSemester/{id}")
    public String deleteSemester(@PathVariable(value = "id") Long id){
        this.semesterService.deleteSemesterById(id);
        return "redirect:/semesterDashBoard";
    }
    @GetMapping("/UpdateSemester/{id}")
    public String updateSemester(@PathVariable(value = "id")Long id,Model model){
        Semester semester=semesterService.getSemesterById(id);
        model.addAttribute(semester);
        return "updateSemester";

    }
}
