package BMS.example.Bookmyshow.Repository;

import BMS.example.Bookmyshow.Models.TheaterSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeats,Integer> {
}
