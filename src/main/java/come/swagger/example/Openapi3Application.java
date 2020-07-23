package come.swagger.example;

import come.swagger.example.Model.Student;
import come.swagger.example.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Openapi3Application implements ApplicationRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Openapi3Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Student student1 = new Student("username1", "username1@gmail.com");
		Student student2 = new Student("username2", "username2@gmail.com");
		Student student3 = new Student("username3", "username3@gmail.com");
		Student student4 = new Student("username4", "username4@gmail.com");
		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);
		studentRepository.save(student4);
	}
}
