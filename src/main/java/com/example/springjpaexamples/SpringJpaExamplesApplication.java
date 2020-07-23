package com.example.springjpaexamples;

import com.example.springjpaexamples.model.Course;
import com.example.springjpaexamples.model.Student;
import com.example.springjpaexamples.model.Person;
import com.example.springjpaexamples.repositories.CourseRepository;
import com.example.springjpaexamples.repositories.StudentRepository;
import com.example.springjpaexamples.repositories.PersonRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringJpaExamplesApplication implements ApplicationRunner {

    @Autowired
    private PersonRepositories personRepositories;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaExamplesApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Person> loadPersons = loadPersonsData();

        loadPersons.forEach(personRepositories::save);
    }

    public List<Person> loadPersonsData() {
        Person person1 = new Person();
        person1.setFirstName("Ahmad");
        person1.setLastName("Nazari");
        person1.setEmail("ahmadnazari@gmail.com");
        person1.setDateOfBirth(LocalDate.of(1995, 2, 2));
        person1.setAge(LocalDate.now().getYear() - person1.getDateOfBirth().getYear());
        person1.setActive(new Random().nextBoolean());

        Person person5 = new Person();
        person5.setFirstName("Jamshid");
        person5.setLastName("Nazari");
        person5.setEmail("jamshidnazari@gmail.com");
        person5.setDateOfBirth(LocalDate.of(1997, 2, 2));
        person5.setAge(LocalDate.now().getYear() - person5.getDateOfBirth().getYear());
        person5.setActive(new Random().nextBoolean());

        Person person2 = new Person();
        person2.setFirstName("Ahmad");
        person2.setLastName("Kamali");
        person2.setEmail("ahmadkamali@gmail.com");
        person2.setDateOfBirth(LocalDate.of(1976, 2, 2));
        person2.setAge(LocalDate.now().getYear() - person2.getDateOfBirth().getYear());
        person2.setActive(new Random().nextBoolean());

        Person person3 = new Person();
        person3.setFirstName("Jamshid");
        person3.setLastName("Kamali");
        person3.setEmail("ahmadnazari@gmail.com");
        person3.setDateOfBirth(LocalDate.of(1995, 2, 2));
        person3.setAge(LocalDate.now().getYear() - person3.getDateOfBirth().getYear());
        person3.setActive(new Random().nextBoolean());


        return Arrays.asList(person1, person2, person3, person5);
    }
}
