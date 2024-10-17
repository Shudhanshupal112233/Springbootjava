package BMS.example.Bookmyshow.Requestdto;

import lombok.Data;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;
@Data
public class BookTIcketRequestDto {
   private List<String> requestseats;
   private int showid;
   private int userId;
}
