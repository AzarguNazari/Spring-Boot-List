package com.example.springjpaexamples;

import com.example.springjpaexamples.model.Employee;
import com.example.springjpaexamples.repositories.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() throws Exception {
        preLoad().forEach(employeeRepository::save);
    }

    @AfterEach
    public void cleanUp(){
        preLoad().forEach(employeeRepository::delete);
    }

    @Test
    public void employeeIsActive(){
        Assert.notNull(employeeRepository, "Employee is not null");
        Assert.isTrue(employeeRepository.count() == 4, "Total number of employees are 4");
        Assert.isTrue(employeeRepository.findByFirstName("firstname1").size() == 1, "Total number of active employees are 2");
    }



    public List<Employee> preLoad(){
         Employee employee1 = new Employee(1, "firstname1", "lastname1", 10, LocalDate.of(1995, 5, 5), LocalDate.of(2020, 2, 2), true, 2000.2);
         Employee employee2 = new Employee(2, "firstname2", "lastname2", 20, LocalDate.of(2007, 5, 5), LocalDate.of(2020, 2, 2), true, 2000.2);
         Employee employee3 = new Employee(3, "firstname3", "lastname3", 30, LocalDate.of(2009, 5, 5), LocalDate.of(2020, 2, 2), false, 2000.2);
         Employee employee4 = new Employee(4, "firstname4", "lastname4", 40, LocalDate.of(2012, 5, 5), LocalDate.of(2020, 2, 2), false, 2000.2);
         return Arrays.asList(employee1, employee2, employee3, employee4);
    }
}
