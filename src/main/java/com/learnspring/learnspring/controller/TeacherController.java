package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.Teacher;
import com.learnspring.learnspring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacherDashBoard")
    public String showTeachers(Model model){
        List<Teacher> allTeachers = teacherService.findByAllTeacher();
        model.addAttribute("allTeacher", allTeachers);
        return "teacherDashBoard";
    }
    @GetMapping("/showNewTeacherForm")
    public String showTeacherForm(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "teacher";

    }
    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
        teacherService.SaveTeacher(teacher);
        return "redirect:/teacherDashBoard";
    }
    @GetMapping("/updateTeacher/{id}")
    public String updateTeacher(@PathVariable(value = "id")Long id,Model model){
        Teacher teacher=teacherService.getTeacherById(id);
        model.addAttribute(teacher);
        return "updateTeacher";
    }
    @GetMapping("/deleteTeacher/{id}")
        public String deleteTeacher(@PathVariable(value = "id") Long id){
        this.teacherService.deleteTeacherById(id);
        return "redirect:/teacherDashBoard";
    }
}
