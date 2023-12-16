package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.AcademicUnit;
import com.learnspring.learnspring.models.Semester;
import com.learnspring.learnspring.models.StudentRegistration;
import com.learnspring.learnspring.services.AcademicUnitService;
import com.learnspring.learnspring.services.SemesterService;
import com.learnspring.learnspring.services.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListStudentPerDepartmentAndSemester {
    @Autowired
    private AcademicUnitService academicUnitService;
    @Autowired
    private StudentRegistrationService studentRegistrationService;
    @Autowired
    private SemesterService semesterService;
@GetMapping("/semesterAndDepartment")
public String semesterAndDepartment(Model model){
    List<Semester> semesterList = semesterService.listAllSemester();
    List<AcademicUnit> academicUnitList = academicUnitService.listAllAcademicUnit();
    model.addAttribute("semesterList1",semesterList);
    model.addAttribute("academicUnitList1",academicUnitList);
    return "stdPerSemesterAndDepartment";
}
    @GetMapping("/studentsBySemesterAndDepartment")
    public String listStudentsBySemesterAndDepartment(
            @RequestParam(value = "semesterId") Long semesterId,
            @RequestParam(value = "departmentId") String departmentId,
            Model model
    ) {
        List<StudentRegistration> students1 = studentRegistrationService.listStudentsBySemesterAndDepartment(semesterId, departmentId);
        List<Semester> semesterList = semesterService.listAllSemester();
        List<AcademicUnit> academicUnitList = academicUnitService.listAllAcademicUnit();
        model.addAttribute("students1", students1);
        model.addAttribute("semesterList1", semesterList);
        model.addAttribute("academicUnitList1", academicUnitList);
        return "stdPerSemesterAndDepartment";  }
}
