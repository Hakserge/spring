package com.learnspring.learnspring.repository;

import com.learnspring.learnspring.models.CourseDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDefinitionRepository extends JpaRepository<CourseDefinition, String> {
}
