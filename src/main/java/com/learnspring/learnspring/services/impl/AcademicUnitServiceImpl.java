package com.learnspring.learnspring.services.impl;

import com.learnspring.learnspring.models.AcademicUnit;
import com.learnspring.learnspring.repository.AcademicUnitRepository;
import com.learnspring.learnspring.services.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicUnitServiceImpl implements AcademicUnitService {
    AcademicUnitRepository academicUnitRepository;
    @Autowired
    public AcademicUnitServiceImpl(AcademicUnitRepository academicUnitRepository){
        this.academicUnitRepository=academicUnitRepository;
    }

   @Override
   public void saveAcademicUnit(AcademicUnit academicUnit) {
      this.academicUnitRepository.save(academicUnit);
   }



    @Override
    public List<AcademicUnit> listAllAcademicUnit() {
        return this.academicUnitRepository.findAll();
    }
}
