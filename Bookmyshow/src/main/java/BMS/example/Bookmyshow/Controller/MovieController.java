package BMS.example.Bookmyshow.Controller;

import BMS.example.Bookmyshow.Models.Movie;
import BMS.example.Bookmyshow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public String addmovie(@RequestBody() Movie movie){
        String result = movieService.addmovie(movie);
        return "movie is added to DB";


    }
}
