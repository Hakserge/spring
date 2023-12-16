package com.learnspring.learnspring.repository;

import com.learnspring.learnspring.models.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicUnitRepository extends JpaRepository<AcademicUnit,String> {
}
