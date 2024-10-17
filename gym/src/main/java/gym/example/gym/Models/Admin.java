package gym.example.gym.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Data

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    private String username;
    private String password;
}
