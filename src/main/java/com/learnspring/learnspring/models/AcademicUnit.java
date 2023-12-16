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
public class AcademicUnit {
    @Id
    @Column(name="code")
    private String code;

    @Column(name="academicname")
    private String name;

    @Column(name="academic_type")
    private String academicType;

    @Enumerated(EnumType.STRING)
    private EAcademicUnit unit;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="parentcode", nullable = true)
    private AcademicUnit parentAcademic;

}
