package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.Student;
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
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/showNewStudentForm")
    public String ShowStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student";
    }
    @PostMapping("/saveStudent")
    public String saverStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/showNewStudentForm";
    }
    @GetMapping("/studentDashBoard")
    public String ShowAllStudent(Model model){
        List<Student> students=studentService.listAllStudent();
        model.addAttribute("allstudent",students);
        return "studentDashBoard";
    }
    @GetMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable(value = "id")Long id,Model model){
        Student student=studentService.updateStudent(id);
        model.addAttribute(student);
        return "updateStudent";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id){
        this.studentService.deleteStudent(id);
        return "redirect:/studentDashBoard";
    }


}
