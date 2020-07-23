package com.example.springjpaexamples.repositories;

import com.example.springjpaexamples.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Optional<Student> findByName(String name);

    @Modifying
    @Query(value = "delete from student where student.id not in (select student_id from course_like)", nativeQuery = true)
    void cleanUpStudentWithNoCourse();
}
