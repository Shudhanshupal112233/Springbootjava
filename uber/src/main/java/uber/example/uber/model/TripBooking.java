package uber.example.uber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tripbooking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripBookingId;

    private String fromLocation; //The start location of the trip
    private String toLocation; //The end location of the trip
    private int distanceInKm;

    @Enumerated(value = EnumType.STRING)
    private TripStatus status;
    private int bill;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @ManyToOne
    @JoinColumn
    private Driver driver;

}
