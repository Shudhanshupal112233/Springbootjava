package BMS.example.Bookmyshow.Controller;

import BMS.example.Bookmyshow.Requestdto.BookTIcketRequestDto;
import BMS.example.Bookmyshow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
     @Autowired
     TicketService ticketService;
    @PostMapping("/book")
    public  String bookticket(@RequestBody BookTIcketRequestDto bookTIcketRequestDto){
        String result= null;
        try {
            result = ticketService.bookticket(bookTIcketRequestDto);
        } catch (Exception e) {
            return " requested seat not available";
        }
        return result;
    }
}
