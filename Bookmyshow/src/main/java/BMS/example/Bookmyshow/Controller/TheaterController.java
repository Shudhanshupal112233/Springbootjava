package BMS.example.Bookmyshow.Controller;

import BMS.example.Bookmyshow.Models.Theater;
import BMS.example.Bookmyshow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/create")
    public  String addTheater(@RequestBody() Theater theater){
       return  theaterService.addTheater(theater);
    }

}
