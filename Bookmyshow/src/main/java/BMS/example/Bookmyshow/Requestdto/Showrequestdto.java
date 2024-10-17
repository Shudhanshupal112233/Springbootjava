package BMS.example.Bookmyshow.Requestdto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class Showrequestdto {

    public class AddShowRequest {

        private LocalDate showDate;
        private LocalTime showTime;

        private String moviename;
        private Integer theaterId;

    }


}
