package com.example.springjpaexamples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private int id;

    @Column private String firstName;
    @Column private String lastName;
    @Column private int age;
    @Column private LocalDate startDate;
    @Column private LocalDate endDate;
    @Column private boolean active;
    @Column private double salary;
}
