package com.learnspring.learnspring.repository;

import com.learnspring.learnspring.models.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration,Long> {
    List<StudentRegistration> findBySemesterId(Long semesterId);
    @Query("select sr from StudentRegistration sr where sr.semester.id = :semesterId and sr.academicunit.code= :departmentId")
    List<StudentRegistration> findStudentBySemesterAndDepartment(
            @Param("semesterId") Long semesterId,
            @Param("departmentId") String departmentId
    );
}

