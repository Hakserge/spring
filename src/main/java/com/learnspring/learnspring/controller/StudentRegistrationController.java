package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.AcademicUnit;
import com.learnspring.learnspring.models.Semester;
import com.learnspring.learnspring.models.Student;
import com.learnspring.learnspring.models.StudentRegistration;
import com.learnspring.learnspring.services.AcademicUnitService;
import com.learnspring.learnspring.services.SemesterService;
import com.learnspring.learnspring.services.StudentRegistrationService;
import com.learnspring.learnspring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentRegistrationController {
    @Autowired
    StudentRegistrationService studentRegistrationService;
    @Autowired
    StudentService studentService;
    @Autowired
    AcademicUnitService academicUnitService;
    @Autowired
    SemesterService semesterService;

    @GetMapping("/showNewStudentRegistrationForm")
    public String showStudentRegistration(Model model){
        StudentRegistration studentRegistration= new StudentRegistration();
        List<Student>students=studentService.listAllStudent();
        List<AcademicUnit>academicList= academicUnitService.listAllAcademicUnit();
        List<Semester> semesters=semesterService.listAllSemester();
        model.addAttribute("studentRegistration" ,studentRegistration);
        model.addAttribute("studentList",students);
        model.addAttribute("academicList", academicList);
        model.addAttribute("semesterList", semesters);

        return "studentRegistration";

    }
    @PostMapping("/saveStudentRegistration")
    public String saveStudentRegistration(@ModelAttribute("studentRegistration") StudentRegistration studentRegistration){
        studentRegistrationService.saveStudentRegistration(studentRegistration);
        return "redirect:/showNewStudentRegistrationForm";
    }
    @GetMapping("/StudentRegistrationDashBoard")
    public String showAllStudentRegistration(Model model){
        List<StudentRegistration> studentRegistrations= studentRegistrationService.listAllStudentRegistration();
        model.addAttribute("listStudentRegistration", studentRegistrations);
        return "studentRegistrationDashBoard";
    }
    @GetMapping("/updateStudentRegistration/{id}")
      public String updateStudentRegistration(@PathVariable(value = "id")Long id,Model model){
        StudentRegistration studentRegistration=studentRegistrationService.getStudentRegistrationById(id);
        List<Student>students=studentService.listAllStudent();
        List<AcademicUnit>academicList= academicUnitService.listAllAcademicUnit();
        List<Semester> semesters=semesterService.listAllSemester();
        model.addAttribute(studentRegistration);
        model.addAttribute("studentList",students);
        model.addAttribute("academicList", academicList);
        model.addAttribute("semesterList", semesters);
        return "updateStudentRegistration";

    }
    @GetMapping("/deleteStudentRegistration/{id}")
    public String deleteStudentRegistration(@PathVariable(value = "id")Long id){
        this.studentRegistrationService.deleteStudentRegistration(id);
        return "redirect:/StudentRegistrationDashBoard";

    }

}
