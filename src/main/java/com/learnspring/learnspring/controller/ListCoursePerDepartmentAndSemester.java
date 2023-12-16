package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.AcademicUnit;
import com.learnspring.learnspring.models.Course;
import com.learnspring.learnspring.models.CourseDefinition;
import com.learnspring.learnspring.models.Semester;
import com.learnspring.learnspring.services.AcademicUnitService;
import com.learnspring.learnspring.services.CourseService;
import com.learnspring.learnspring.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListCoursePerDepartmentAndSemester {
    @Autowired
    SemesterService semesterService;
    @Autowired
    AcademicUnitService academicUnitService;
    @Autowired
    CourseService courseService;

    @GetMapping("/DepartmentAndSemester")
    public String courseAndSemester(Model model) {
        List<AcademicUnit> academicUnitList = academicUnitService.listAllAcademicUnit();
        List<Semester> semesterList = semesterService.listAllSemester();
        model.addAttribute("academicList", academicUnitList);
        model.addAttribute("semesterList2", semesterList);
        return "courPerDepartmentAndSemester";
    }
    @GetMapping("/ListDepartmentAndSemester")
    public String ListDepartmentAndSemester(
            @RequestParam("departmentId")String acaId,
            @RequestParam("semesterId")Long semesterId,
            Model model){
        List<Course> ListCoursePerDepAndSem=courseService.listCoursePerDepartmentAndSemester(acaId,semesterId);
        List<AcademicUnit> academicUnitList = academicUnitService.listAllAcademicUnit();
         List<Semester>semesterList=semesterService.listAllSemester();
        model.addAttribute("academicList",academicUnitList );
        model.addAttribute("semesterList2",semesterList);
        model.addAttribute("courseList",ListCoursePerDepAndSem);
        return "courPerDepartmentAndSemester";
    }

}
