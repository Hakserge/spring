package com.learnspring.learnspring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StudentCourse {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="credits")
    private Long credits;

    @Column(name="results")
    private String results;

    @ManyToOne
    @JoinColumn(name="studentregistration", nullable = true)
    private StudentRegistration studentregistration;

    @ManyToOne
    @JoinColumn(name = "course_code", nullable = true)
    private Course course;
}
