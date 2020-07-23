package com.example.springjpaexamples.repositories;

import com.example.springjpaexamples.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
