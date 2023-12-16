package com.learnspring.learnspring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long code;

    @ManyToOne
    @JoinColumn(name = "coursedefinition_code")
    private CourseDefinition cousedefinition;

    @ManyToOne
    @JoinColumn(name = "teacher_code")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "academicunit_code")
     private AcademicUnit academicunit;

}
