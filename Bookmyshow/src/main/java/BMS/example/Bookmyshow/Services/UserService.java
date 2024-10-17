package BMS.example.Bookmyshow.Services;

import BMS.example.Bookmyshow.Models.User;
import BMS.example.Bookmyshow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
   public UserRepository userRepository;

    public String adduser(User user){


        try{
            userRepository.save(user);

        } catch (Exception e) {
            return "User cannot added";
        }
        return " User has been saved to Db";
    }

    public List<User> allusers(){
        return userRepository.findAll();
    }
}
