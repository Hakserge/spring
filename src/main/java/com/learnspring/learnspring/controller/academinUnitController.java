package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.AcademicUnit;
import com.learnspring.learnspring.services.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class academinUnitController {
    @Autowired
    AcademicUnitService academicUnitService;
    @GetMapping("/showNewAcademicUnitForm")
    public String showAcademicUnit(Model model){
        AcademicUnit academicUnit= new AcademicUnit();
        List<AcademicUnit>academicUnitList=academicUnitService.listAllAcademicUnit();
        model.addAttribute("academicUnit" ,academicUnit);
        model.addAttribute("academicUnitList",academicUnitList);
        return "academicUnit";
    }
    @PostMapping("/saveAcademicUnit")
    public  String saveAcademicUnit(@ModelAttribute("academicUnit") AcademicUnit academicUnit){
        academicUnitService.saveAcademicUnit(academicUnit);
        return "redirect:/showNewAcademicUnitForm";

    }
    @GetMapping("/academicUnitDashBoard")
    public String showAllAcademicUnit(Model model){
        List<AcademicUnit> academicUnits =academicUnitService.listAllAcademicUnit();
        model.addAttribute("listAcademicUnit",academicUnits);
        return "academicUnitDashBoard";
    }
}
