package BMS.example.Bookmyshow.Controller;

import BMS.example.Bookmyshow.Models.Shows;
import BMS.example.Bookmyshow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

     @Autowired
    ShowService showService;

    @PostMapping("/add")
    public String addshow(@RequestBody() Shows shows){

        return showService.addshow(shows);
    }


}
