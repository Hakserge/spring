package com.learnspring.learnspring.services.impl;

import com.learnspring.learnspring.models.Semester;
import com.learnspring.learnspring.repository.SemesterRepository;
import com.learnspring.learnspring.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterServiceImpl implements SemesterService {
    SemesterRepository semesterRepository;
    @Autowired
    public SemesterServiceImpl(SemesterRepository semesterRepository){
        this.semesterRepository=semesterRepository;
    }
    @Override
    public void SaveSemester(Semester semester) {
        this.semesterRepository.save(semester);
    }

    @Override
    public List<Semester> listAllSemester() {
        return this.semesterRepository.findAll();
    }

    @Override
    public void deleteSemesterById(Long id) {
         this.semesterRepository.deleteById(id);
    }

    @Override
    public Semester getSemesterById(Long id) {
        Optional<Semester> optional=semesterRepository.findById(id);
          Semester semester=null;
          if (optional.isPresent()){
              semester=optional.get();
          }else {
              throw new RuntimeException("semester not found for id"+id);
          }
        return semester;
    }
}
