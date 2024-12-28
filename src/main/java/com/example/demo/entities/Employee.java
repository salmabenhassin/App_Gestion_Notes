package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn(name = "usertype",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("User")
public class Employee implements Serializable{

    @Id
    @Column(length = 100)
    private String login;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;
    private String token;
}
