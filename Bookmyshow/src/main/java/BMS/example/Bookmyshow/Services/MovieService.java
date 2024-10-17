package BMS.example.Bookmyshow.Services;

import BMS.example.Bookmyshow.Models.Movie;
import BMS.example.Bookmyshow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public  String addmovie(Movie movie){

        try{
            movieRepository.save(movie);
        } catch (Exception e) {
            return "Movie not added";
        }
        return "movie added succefully";
    }
}
