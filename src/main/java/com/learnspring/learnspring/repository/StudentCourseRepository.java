package com.learnspring.learnspring.repository;

import com.learnspring.learnspring.models.Course;
import com.learnspring.learnspring.models.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse ,Long> {
    @Query("select st from StudentCourse st where st.course.cousedefinition.Code = :courseId and st.studentregistration.semester.id = :semesterID")
    List<StudentCourse> listStudentPerCourseAndSemester(
            @Param("courseId") String courseId,
            @Param("semesterID") Long semesterID
    );
    @Query("select st from StudentCourse st where st.course.cousedefinition.Code= :courseId")
    List<StudentCourse>listStudentPerCourse(
            @Param("courseId") String courseId
    );
}
