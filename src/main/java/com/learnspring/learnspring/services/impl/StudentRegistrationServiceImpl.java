package com.learnspring.learnspring.services.impl;

import com.learnspring.learnspring.models.StudentRegistration;
import com.learnspring.learnspring.repository.StudentRegistrationRepository;
import com.learnspring.learnspring.services.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
    StudentRegistrationRepository studentRegistrationRepository;

    @Autowired
    public StudentRegistrationServiceImpl(StudentRegistrationRepository studentRegistrationRepository){
        this.studentRegistrationRepository=studentRegistrationRepository;
    }
    @Override
    public void saveStudentRegistration(StudentRegistration studentRegistration) {
        this.studentRegistrationRepository.save(studentRegistration);
    }

    @Override
    public List<StudentRegistration> listAllStudentRegistration() {
        return this.studentRegistrationRepository.findAll();
    }

    @Override
    public List<StudentRegistration> listStudentsBySemester(Long semesterId) {
        return studentRegistrationRepository.findBySemesterId(semesterId);
    }
    @Override
    public List<StudentRegistration> listStudentsBySemesterAndDepartment(Long semesterId, String departmentId) {
        return studentRegistrationRepository.findStudentBySemesterAndDepartment(semesterId, departmentId);
    }

    @Override
    public void deleteStudentRegistration(Long id) {
        this.studentRegistrationRepository.deleteById(id);
    }

    @Override
    public StudentRegistration getStudentRegistrationById(Long id) {
        Optional<StudentRegistration> optional=studentRegistrationRepository.findById(id);
        StudentRegistration studentRegistration=null;
        if (optional.isPresent()){
            studentRegistration=optional.get();
        }else {
            throw  new RuntimeException("the studentRegistration id not found"+id);
        }
        return studentRegistration;
    }

}
