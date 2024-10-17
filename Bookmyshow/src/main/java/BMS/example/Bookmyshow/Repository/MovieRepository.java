package BMS.example.Bookmyshow.Repository;

import BMS.example.Bookmyshow.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {


}
