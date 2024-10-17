package BMS.example.Bookmyshow.Controller;

import BMS.example.Bookmyshow.Models.User;
import BMS.example.Bookmyshow.Repository.UserRepository;
import BMS.example.Bookmyshow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/user")

public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/create")
    public String adduser(@RequestBody() User user){
         String result =userService.adduser(user);
         return result;
    }

    @GetMapping("/getuser")
    public List<User> allusers(){
        List<User> anslist= userService.allusers();
        return anslist;
    }
}
