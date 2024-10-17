package BMS.example.Bookmyshow.Services;

import BMS.example.Bookmyshow.Models.Shows;
import BMS.example.Bookmyshow.Models.Showseat;
import BMS.example.Bookmyshow.Models.Ticket;
import BMS.example.Bookmyshow.Models.User;
import BMS.example.Bookmyshow.Repository.ShowRepository;
import BMS.example.Bookmyshow.Repository.TicketRepository;
import BMS.example.Bookmyshow.Repository.UserRepository;
import BMS.example.Bookmyshow.Requestdto.BookTIcketRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    public String bookticket(BookTIcketRequestDto bookTIcketRequestDto) throws Exception {
        List<String> requestedseats = bookTIcketRequestDto.getRequestseats();

        Shows shows = showRepository.findById(bookTIcketRequestDto.getShowid()).get();

        User user = userRepository.findById(bookTIcketRequestDto.getUserId()).get();

        List<Showseat> showseats = shows.getShowseatList();

        List<Showseat> bookedseats = new ArrayList<>();

        for(String s:requestedseats){
            System.out.println(s+" --");
        }
        for (Showseat showseat : showseats) {
            String seatNo = showseat.getSeatnumber();
            System.out.println(seatNo+"-->");

            if (showseat.isBooked() == false && requestedseats.contains(seatNo)) {
                bookedseats.add(showseat);
            }
        }
        if (bookedseats.size() != requestedseats.size()) {
            throw new Exception(" Requested seats are not available");
        }
        Ticket ticket = new Ticket();
        double totalamount = 0;
        double multipler = shows.getMultipler();
        String allotedseat = " ";
        int rate = 0;
        for (Showseat bookedseat : bookedseats) {
            bookedseat.setBooked(true);
            bookedseat.setBookedAt(new Date());
            bookedseat.setTicket(ticket);
            bookedseat.setShows(shows);

            String SeatNo = bookedseat.getSeatnumber();
            allotedseat = allotedseat +SeatNo+ " ,";
            if (SeatNo.charAt(0) == '1')
                rate = 100;
            else
                rate = 200;

            totalamount = totalamount + rate * multipler;

        }

        ticket.setBooked_at(new Date());
        ticket.setAmount((int) totalamount);
        ticket.setAlloted_seat(allotedseat);
        ticket.setUser(user);
        ticket.setShows(shows);
        ticket.setShowseatList(bookedseats);

        ticketRepository.save(ticket);


        return "successfully added";
    }
}