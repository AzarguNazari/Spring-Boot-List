package com.example.springjpaexamples.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
@Setter
@Getter
public class Course {

    @Id
    private int id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "likedCourses")
    Set<Student> likes;

    public Course(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Course(){}
}
