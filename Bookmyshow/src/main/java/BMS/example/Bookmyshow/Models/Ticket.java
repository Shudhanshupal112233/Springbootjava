package BMS.example.Bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Ticket")
@Data
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  int id;

    private String alloted_seat;


    private  int amount;

    private Date booked_at;

    @ManyToOne
    @JoinColumn
    private  User user;


    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<Showseat> showseatList;


    @ManyToOne
    @JoinColumn
    private  Shows shows;





}
