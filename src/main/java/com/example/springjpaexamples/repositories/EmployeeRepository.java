package com.example.springjpaexamples.repositories;

import com.example.springjpaexamples.model.Employee;
import com.example.springjpaexamples.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Person> findByFirstName(String firstname);
//    List<Person> findByFirstNameAndLastName(String firstname, String lastname);
//    List<Person> findByFirstNameOrLastName(String firstName, String lastname);
//    List<Person> findByLastName(String lastName);
//    List<Person> findByAgeLessThan(int age);
//    List<Person> findByAge(int age);
//    List<Person> findByAgeGreaterThan(int age);
//    List<Person> findByAgeGreaterThanEqual(int age);
//    List<Person> findByDateOfBirthAfter(LocalDate afterDate);
//    List<Person> findByDateOfBirthBefore(LocalDate afterDate);
//      List<Person> findByActiveTrue();
//    List<Person> findByAgeBetween(int minAge, int maxAge);
//    List<Person> findBAgeLessThan(int age);
//    List<Person> findBAgeLessThanEqual(int age);
//    List<Person> findByEmailIsNull();
//    List<Person> findByEmailIsNotNull();
//    List<Person> findByEmailNotNull();
//    List<Person> findByEmailLike(String like);
//    List<Person> findByEmailNotLike(String like);
//    List<Person> findByFirstNameStartingWith(String startWith);
//    List<Person> findByEndingWith(String endingWith);
//    List<Person> findByLastNameContaining(String containingWord);
//    List<Person> findByEmailOrderByLastName(String email);
//    List<Person> findByFirstNameNot(String firstName);
//    List<Person> findByAgeIn(Collection<Integer> ages);
//    List<Person> findByAgeNotIn(Collection<Integer> ages);
//    List<Person> findByEmailOrderByLastNameIgnoreCase(String email);
}
