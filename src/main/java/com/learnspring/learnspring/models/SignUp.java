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
public class SignUp {
    private String firstname;
    private String lastname;
    @Id
    private String email;
    private String password;

}
