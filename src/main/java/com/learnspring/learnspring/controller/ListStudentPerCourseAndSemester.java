package com.learnspring.learnspring.controller;

import com.learnspring.learnspring.models.CourseDefinition;
import com.learnspring.learnspring.models.Semester;
import com.learnspring.learnspring.models.StudentCourse;
import com.learnspring.learnspring.services.CourseDefinitionService;
import com.learnspring.learnspring.services.SemesterService;
import com.learnspring.learnspring.services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListStudentPerCourseAndSemester {
    @Autowired
    StudentCourseService studentCourseService;
    @Autowired
    SemesterService semesterService;
    @Autowired
    CourseDefinitionService courseDefinitionService;
    @GetMapping("/courseAndSemester")
    public String courseAndSemester(Model model){
        List<CourseDefinition> courseDefinitionList=courseDefinitionService.listAllCourses();
        List<Semester>semesterList=semesterService.listAllSemester();
        model.addAttribute("courseDefList",courseDefinitionList);
        model.addAttribute("semesterList2",semesterList);
        return "stdPerCourseAndSemester";
    }
    @GetMapping("/ListCourseAndSemester")
    public String ListCourseAndSemester(
            @RequestParam(value = "courseDefId") String courseDefId,
        @RequestParam(value = "semesterId")Long semesterId ,Model model){
        List<StudentCourse>studentCourses=studentCourseService.listStudentPerCourseAndSemester(courseDefId,semesterId);
        List<CourseDefinition> courseDefinitionList=courseDefinitionService.listAllCourses();
        List<Semester>semesterList=semesterService.listAllSemester();
        model.addAttribute("courseDefList",courseDefinitionList);
        model.addAttribute("semesterList2",semesterList);
        model.addAttribute("studentList3",studentCourses);
        return "stdPerCourseAndSemester";

    }
}
