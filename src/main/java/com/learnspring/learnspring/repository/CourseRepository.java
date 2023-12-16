package com.learnspring.learnspring.repository;

import com.learnspring.learnspring.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select cour from Course cour where cour.academicunit.code = :acaId and cour.semester.id = :semesterId")
    List<Course> listCoursePerDepartmentAndSemester(
            @Param("acaId") String acaId,
            @Param("semesterId") Long semesterId
    );

}
