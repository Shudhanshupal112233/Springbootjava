package BMS.example.Bookmyshow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Theater")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private  String address;

    @OneToMany(mappedBy = "theater" ,cascade = CascadeType.ALL)
    List<TheaterSeats> theaterSeats;

    @OneToMany(mappedBy = "theater" ,cascade = CascadeType.ALL)
    List<Shows> showsList;


}
