package BMS.example.Bookmyshow.Services;

import BMS.example.Bookmyshow.Enum.SeatType;
import BMS.example.Bookmyshow.Models.Theater;
import BMS.example.Bookmyshow.Models.TheaterSeats;
import BMS.example.Bookmyshow.Repository.TheaterRepository;
import BMS.example.Bookmyshow.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    public  TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public String addTheater(Theater theater){

            theaterRepository.save(theater);


        List<TheaterSeats> theaterSeats = createTheaterseats();
        theater.setTheaterSeats(theaterSeats);

        for(TheaterSeats theaterSeat :theaterSeats){
            theaterSeat.setTheater(theater);
        }
        theaterRepository.save(theater);

     return "save to db";
    }



    private   List<TheaterSeats> createTheaterseats(){

        List<TheaterSeats> seatsList = new ArrayList<>();
        TheaterSeats theaterSeat1 = new TheaterSeats("1A",SeatType.SILVER,100);
        TheaterSeats theaterSeat2= new TheaterSeats("2A",SeatType.SILVER,100);
        TheaterSeats theaterSeat3 = new TheaterSeats("3B",SeatType.GOLD,250);
        TheaterSeats theaterSeat4 = new TheaterSeats("4B",SeatType.GOLD,250);
        TheaterSeats theaterSeat5 = new TheaterSeats("5C",SeatType.PLATINUM,300);
        TheaterSeats theaterSeat6 = new TheaterSeats("6C",SeatType.PLATINUM,300);
        TheaterSeats theaterSeat7 = new TheaterSeats("7D",SeatType.PLATINUM,300);
        //Save all the generated Theater seats into the DB
        seatsList.add(theaterSeat1);
        seatsList.add(theaterSeat2);
        seatsList.add(theaterSeat3);
        seatsList.add(theaterSeat4);
        seatsList.add(theaterSeat5);
        seatsList.add(theaterSeat6);
        seatsList.add(theaterSeat7);

        theaterSeatRepository.saveAll(seatsList);
        return seatsList;


    }


}
