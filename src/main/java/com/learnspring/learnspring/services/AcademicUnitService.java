package com.learnspring.learnspring.services;

import com.learnspring.learnspring.models.AcademicUnit;

import java.util.List;

public interface AcademicUnitService {
    void saveAcademicUnit(AcademicUnit academicUnit);
    List<AcademicUnit> listAllAcademicUnit();
}
