package BMS.example.Bookmyshow.Repository;

import BMS.example.Bookmyshow.Models.Showseat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<Showseat,Integer> {
}
