package come.swagger.example.interfaces;

import come.swagger.example.Model.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentServiceInterface {

    @Operation(summary = "get list of students")
    @GetMapping("/")
    List<Student> getAllStudents();

    @ApiResponses(value = {@ApiResponse(description = "Succesfull", responseCode = "200", content = @Content(schema = @Schema(implementation = Student.class)))})
    @Operation(summary = "get specificat student")
    @GetMapping("/{studentID}")
    Student getStudentByID(@PathVariable("studentID") int id);
}
