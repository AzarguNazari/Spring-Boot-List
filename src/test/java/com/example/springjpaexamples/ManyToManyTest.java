package com.example.springjpaexamples;

import com.example.springjpaexamples.model.Course;
import com.example.springjpaexamples.model.Student;
import com.example.springjpaexamples.repositories.CourseRepository;
import com.example.springjpaexamples.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;

@SpringBootTest
public class ManyToManyTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    void addNewCourseToStudents(){
        Student student1 = studentRepository.findById(1).orElse(null);
        Assert.notNull(student1, "Ahmad is present");

        Course course2 = courseRepository.findById(2).orElse(null);
        Assert.notNull(course2, "Chemistry course is present");

        student1.getLikedCourses().add(course2);

        studentRepository.save(student1);

        student1 = studentRepository.findById(1).orElse(null);
        Assert.notNull(student1, "Ahmad is present");
        Assert.isTrue(student1.getLikedCourses().size() == 2, "Ahmad has two courses");

    }

    @Test
    public void ifAhmadHasNo_shouldBeRemoved(){

        Student student = studentRepository.findByName("Ahmad").orElse(null);
        Assert.notNull(student, "Ahmad exists in database");

        student.getLikedCourses().clear();

        studentRepository.save(student);

        student = studentRepository.findByName("Ahmad").orElse(null);
        Assert.isTrue(student.getLikedCourses().size() == 0, "Ahmad has no course");

        if(student.getLikedCourses().size() == 0){
            studentRepository.cleanUpStudentWithNoCourse();
            student = studentRepository.findByName("Ahmad").orElse(null);
            Assert.isNull(student, "Ahmad doesn't exist in database");
        }



    }
}
