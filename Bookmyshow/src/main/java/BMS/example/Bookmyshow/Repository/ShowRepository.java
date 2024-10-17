package BMS.example.Bookmyshow.Repository;

import BMS.example.Bookmyshow.Models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Shows,Integer> {

}
