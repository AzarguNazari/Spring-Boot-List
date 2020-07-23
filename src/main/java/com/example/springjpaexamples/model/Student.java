package com.example.springjpaexamples.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    private int id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> likedCourses;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Student(){}
}
