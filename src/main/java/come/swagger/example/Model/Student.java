package come.swagger.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    @JsonIgnore
    private int id;

    @Column(name = "student_name")
    private String username;

    @Column(name = "email")
    private String email;

    public Student(String username, String email){
        this.username = username;
        this.email = email;
    }
}
