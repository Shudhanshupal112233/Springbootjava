package BMS.example.Bookmyshow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Shows")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  int id;

    private LocalDate showDate;

    private LocalTime showtime;

    private  double multipler;
    private  String moviename;

    private int theaterid;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date creationon;

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedon;


    @ManyToOne
    @JoinColumn
    private  Movie movie;


    @ManyToOne
    @JoinColumn
    private  Theater theater;

    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    private List<Showseat> showseatList;

    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    private List<Ticket> ticketList;


}




