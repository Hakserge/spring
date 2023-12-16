package com.learnspring.learnspring.controller;


import com.learnspring.learnspring.models.CourseDefinition;
import com.learnspring.learnspring.models.Teacher;
import com.learnspring.learnspring.services.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseDefinitionController {
    @Autowired
    CourseDefinitionService courseDefinitionService;
    @GetMapping("/showNewCourseDefinitionForm")
    public String showCourseDefinitionForm(Model model){
    CourseDefinition courseDefinition= new CourseDefinition();
        model.addAttribute("courseDefinition",courseDefinition);
        return "courseDefinition";
}
@PostMapping("/saveCourseDefinition")
public String saveCourseDefinition(@ModelAttribute("courseDefinition") CourseDefinition courseDefinition){
        courseDefinitionService.saveCourseDefinition(courseDefinition);
        return "redirect:/showNewCourseDefinitionForm";
}
@GetMapping("/courseDefinitionDashBoard")
public String showAllCourseDefinition( Model model){
    List<CourseDefinition> courseDefinitions=courseDefinitionService.listAllCourses();
    model.addAttribute("allcourseDefinitions",courseDefinitions);
    return "courseDefinitionDashBoard";
}
@GetMapping("/updateCourseDefinition/{id}")
public String updateCourseDefinition(@PathVariable(value = "id")String code, Model model){
        CourseDefinition courseDefinition=courseDefinitionService.getCourseDefinitionById(code);
        model.addAttribute(courseDefinition);
        return "redirect:/courseDefinitionDashBoard";
    }
    @GetMapping("/deleteCourseDefinition/{id}")
    public String deleteCourseDefinition(@PathVariable(value = "id") String code){
        this.courseDefinitionService.deleteCourseDefinitionById(code);
        return "redirect:/courseDefinitionDashBoard";
    }
}
