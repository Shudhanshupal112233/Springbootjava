import jakarta.persistence.*;
import lombok.*;

@Entity //This is a description/reflection of a table
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(unique = true)
    private String Username;

    private Integer age;

    private String country;

    private String mobile;
}
