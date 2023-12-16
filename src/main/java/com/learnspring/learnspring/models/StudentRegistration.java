package com.learnspring.learnspring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="regno")
    private Student Studentid;

    @Column(name="registrationdate")
    private String RegistrationDate;

    @Column(name = "RegistrationStatus")
    private ERegistrationStatus eRegistrationStatus;

    @OneToOne
    @JoinColumn(name="academicunit_code")
    private AcademicUnit academicunit;

    @ManyToOne
    @JoinColumn(name="semester_id")
    private Semester semester;
}
