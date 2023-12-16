package com.learnspring.learnspring.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TeacherDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String id_passport;
    private String birthDate;
    private String gender;
    private String degree;
    private String nationality;
}
