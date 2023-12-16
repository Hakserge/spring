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
public class CourseDefinition {
    @Id
    private String Code;
    private String Name;
    private String Description;
    @OneToOne
    private Course course;

}
