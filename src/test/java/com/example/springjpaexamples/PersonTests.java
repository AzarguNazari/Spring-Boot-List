package com.example.springjpaexamples;

import com.example.springjpaexamples.model.Person;
import com.example.springjpaexamples.repositories.PersonRepositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class PersonTests {

    @Autowired
    PersonRepositories personRepositories;

    @Test
    void contextLoads() {
    }

    @Test
    public void Age12(){
        List<Person> persons = personRepositories.findByAge(12);
        Assert.isTrue(persons.size() > 0, "size is " + persons.size());
    }

    @Test
    public void firstNameAhmadAndLastNameNazari(){
        List<Person> persons = personRepositories.findByFirstNameAndLastName("Ahmad", "Nazari");
        Assert.isTrue(persons.size() == 1, "size is " + persons.size());
    }

    @Test
    public void emailAhmadnazari(){
        List<Person> persons = personRepositories.findByEmail("ahmadnazari@gmail.com");
        Assert.isTrue(persons.size() == 1, "size is " + persons.size());
    }

    @Test
    public void sameLastNames(){
        List<Person> persons = personRepositories.findByFirstNameOrLastName("Ahmad", "Nazari");
        persons.forEach(System.out::println);
        Assert.isTrue(persons.size() > 0, "size is " + persons.size());
    }

    @Test
    public void ageGreatherThan12(){
        List<Person> persons = personRepositories.findByAgeGreaterThanEqual(12);
        persons.forEach(System.out::println);
        Assert.isTrue(persons.size() > 0, "size is " + persons.size());
    }

    @Test
    public void activePersons(){
        List<Person> persons = personRepositories.findByActiveTrue();
        persons.forEach(System.out::println);
        Assert.isTrue(persons.size() > 0, "size is " + persons.size());
    }

    @Test
    public void personsBetween23And25(){

        List<Person> byAgeBetween = personRepositories.findByAgeBetween(23, 25);
        Assert.isTrue(byAgeBetween.size() == 3, "There are some person between age of 23 and 26");

    }

}
