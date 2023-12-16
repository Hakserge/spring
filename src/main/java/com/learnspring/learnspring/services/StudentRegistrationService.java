package com.learnspring.learnspring.services;

import com.learnspring.learnspring.models.StudentRegistration;

import java.util.List;

public interface StudentRegistrationService {
    void saveStudentRegistration(StudentRegistration studentRegistration);
    List<StudentRegistration> listAllStudentRegistration();
    List<StudentRegistration> listStudentsBySemester(Long semesterId);
    List<StudentRegistration> listStudentsBySemesterAndDepartment(Long semesterId, String departmentId);

    void deleteStudentRegistration(Long id);
    StudentRegistration getStudentRegistrationById(Long id);

}
