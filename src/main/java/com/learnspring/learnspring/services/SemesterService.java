package com.learnspring.learnspring.services;

import com.learnspring.learnspring.models.Semester;

import java.util.List;

public interface SemesterService {
    void SaveSemester(Semester semester);
    List<Semester> listAllSemester();
     void deleteSemesterById(Long id);
     Semester getSemesterById(Long id);
}
