package BMS.example.Bookmyshow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Movies")
@Data
@Builder
@AllArgsConstructor

@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(unique = true,nullable = false)
    private String moviename;

    private Date releasedate;

    private int duration;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Shows> shows;
}
