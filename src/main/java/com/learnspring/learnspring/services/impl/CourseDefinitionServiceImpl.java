package com.learnspring.learnspring.services.impl;

import com.learnspring.learnspring.models.CourseDefinition;
import com.learnspring.learnspring.models.Teacher;
import com.learnspring.learnspring.repository.CourseDefinitionRepository;
import com.learnspring.learnspring.services.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseDefinitionServiceImpl implements CourseDefinitionService {
    CourseDefinitionRepository courseDefinitionRepository;
    @Autowired
    public CourseDefinitionServiceImpl(CourseDefinitionRepository courseDefinitionRepository){
        this.courseDefinitionRepository=courseDefinitionRepository;
    }

    @Override
    public void saveCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinitionRepository.save(courseDefinition);
    }

    @Override
    public List<CourseDefinition> listAllCourses() {
        return this.courseDefinitionRepository.findAll();
    }

    @Override
    public CourseDefinition getCourseDefinitionById(String code) {
        Optional<CourseDefinition> optional=courseDefinitionRepository.findById(code);
        CourseDefinition courseDefinition=null;
        if (optional.isPresent()){
            courseDefinition=optional.get();
        }else {
            throw new RuntimeException("teacher id not found "+code);
        }
        return courseDefinition;
    }

    @Override
    public void deleteCourseDefinitionById(String code) {
this.courseDefinitionRepository.deleteById(code);
    }
}
