package BMS.example.Bookmyshow.Models;


import BMS.example.Bookmyshow.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.TransactionUsageException;

import java.util.Date;

import static java.lang.Boolean.FALSE;

@Entity
@Table(name = "ShowSeat")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Showseat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  int id;

    private  String Seatnumber;

    @Enumerated(value = EnumType.STRING)
    public SeatType seatType;


    private boolean  booked;

     private Date bookedAt;

    public Showseat(String seatnumber, SeatType seatType) {
        this.Seatnumber = seatnumber;
        this.seatType = seatType;


    }

    @ManyToOne
    @JoinColumn
    private Shows shows;

    @ManyToOne
    @JoinColumn
    private  Ticket ticket;


}
