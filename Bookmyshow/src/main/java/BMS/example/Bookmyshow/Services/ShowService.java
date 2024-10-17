package BMS.example.Bookmyshow.Services;

import BMS.example.Bookmyshow.Enum.SeatType;
import BMS.example.Bookmyshow.Models.*;
import BMS.example.Bookmyshow.Repository.*;
import BMS.example.Bookmyshow.Requestdto.Showrequestdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;



    public String addshow(Shows shows){

      showRepository.save(shows);






        List<Showseat>showseatList= createshowseat();

        shows.setShowseatList(showseatList);
        for(Showseat showseat:showseatList){
            showseat.setShows(shows);
        }
        showRepository.save(shows);

        return "save to db";
    }



    private   List<Showseat> createshowseat(){

        List<Showseat> seatsList = new ArrayList<>();
        Showseat showSeat1 = new Showseat("1A", SeatType.SILVER);
        Showseat showSeat2 =  new Showseat("2A",SeatType.SILVER);
        Showseat showSeat3 =  new Showseat("3B",SeatType.SILVER);
        Showseat showSeat4 =  new Showseat("4B",SeatType.GOLD);
        Showseat showSeat5 =  new Showseat("5C",SeatType.GOLD);
        Showseat showSeat6 =  new Showseat("6C",SeatType.PLATINUM);
        Showseat showSeat7 =  new Showseat("7D",SeatType.PLATINUM);

        //Save all the generated Theater seats into the DB
        seatsList.add(showSeat1);
        seatsList.add(showSeat2);
        seatsList.add(showSeat3);
        seatsList.add(showSeat4);
        seatsList.add(showSeat5);
        seatsList.add(showSeat6);
        seatsList.add(showSeat7);

        showSeatRepository.saveAll(seatsList);
        return seatsList;


    }


}
