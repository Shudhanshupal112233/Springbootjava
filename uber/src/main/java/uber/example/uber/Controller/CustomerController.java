package uber.example.uber.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uber.example.uber.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import uber.example.uber.Services.CustomerService;
import uber.example.uber.model.TripBooking;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;



    @PostMapping("/add")
    public  String addcustomer(@RequestBody Customer customer){
        String result = customerService.addcustomer( customer);
        return  result;
    }

    @DeleteMapping("/delete")
    public void deletecustomer(@RequestParam Integer customerId){
        customerService.deletecustomer( customerId);

    }


    @PostMapping("/bookTrip")
    public ResponseEntity<TripBooking> booktrip(@RequestParam Integer customerId,@RequestParam String fromLocation, @RequestParam String toLocation, @RequestParam Integer distanceInKm) throws  Exception{
        TripBooking bookedTrip = customerService.booktrip(customerId, fromLocation, toLocation, distanceInKm);
        return new ResponseEntity<TripBooking>(bookedTrip, HttpStatus.CREATED);

    }

    @DeleteMapping("/cancelTrip")
    public void cancelTrip(@RequestParam Integer tripId){
        customerService.cancelTrip(tripId);
    }

    @DeleteMapping("/complete")
    public void completeTrip(@RequestParam Integer tripId){
        customerService.completeTrip(tripId);
    }






}
