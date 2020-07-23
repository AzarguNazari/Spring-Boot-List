package come.swagger.example.controller;

import come.swagger.example.Model.Student;
import come.swagger.example.Repositories.StudentRepository;
import come.swagger.example.interfaces.StudentServiceInterface;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Students")
public class StudentController implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByID(int id){
        return studentRepository.findById(id).get();
    }

}
