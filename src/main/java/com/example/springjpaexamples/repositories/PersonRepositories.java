package com.example.springjpaexamples.repositories;

import com.example.springjpaexamples.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface PersonRepositories extends JpaRepository<Person, Integer> {
    // where x.firstName =?1
    List<Person> findByFirstName(String firstname);
    // where x.firstName=?1 and x.lastName=?2
    List<Person> findByFirstNameAndLastName(String firstname, String lastname);
    // where x.firstName=?1 or x.lastName=?2
    List<Person> findByFirstNameOrLastName(String firstName, String lastname);
    // where x.lastName =?1
    List<Person> findByLastName(String lastName);
    // where x.age=?1
    List<Person> findByAge(int age);
    // where x.email=?1
    List<Person> findByEmail(String firstname);
    // where x.age<?1
    List<Person> findByAgeLessThan(int age);
    // where x.age >?1
    List<Person> findByAgeGreaterThan(int age);
    // where x.age >= ?1
    List<Person> findByAgeGreaterThanEqual(int age);
    // where x.birthDate > ?1
    List<Person> findByDateOfBirthAfter(LocalDate afterDate);
    // where x.birthDate < ?1
    List<Person> findByDateOfBirthBefore(LocalDate afterDate);
    // where x.active=true
    List<Person> findByActiveTrue();

    // where x.age >= minAge and x.age <= maxAge
    List<Person> findByAgeBetween(int minAge, int maxAge);

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
