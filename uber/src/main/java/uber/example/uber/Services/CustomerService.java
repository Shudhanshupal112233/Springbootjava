package uber.example.uber.Services;

import uber.example.uber.Repository.DriverRepository;
import uber.example.uber.Repository.TripBookingRepository;
import uber.example.uber.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uber.example.uber.Repository.CustomerRepository;
import uber.example.uber.model.Driver;
import uber.example.uber.model.TripBooking;
import uber.example.uber.model.TripStatus;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
   public CustomerRepository customerRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    TripBookingRepository tripBookingRepository;


    public  String addcustomer(Customer customer){

            customerRepository.save(customer);

        return "customer added successfully";
    }


     public String deletecustomer(Integer customerId){
         Customer customer = customerRepository.findById(customerId).get();
         customerRepository.delete(customer);
             return "deleted";

     }

    public TripBooking booktrip(Integer customerId  , String fromLocation, String toLocation, int distanceInKm) throws Exception {
        TripBooking tripBooking = new TripBooking();
        Driver driver = null;

        List<Driver> driverList = driverRepository.findAll();

        for (Driver driver1:driverList){

            if(driver1.getCab().getAvailable()==Boolean.TRUE){
                if((driver==null)||  (driver.getDriverId()> driver1.getDriverId())){
                    driver =driver1;
                }
            }
        }
        if(driver == null){
            throw new Exception("No cab available!");
        }

        Customer customer = customerRepository.findById(customerId).get();
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(driver);
        driver.getCab().setAvailable(Boolean.FALSE);
        tripBooking.setFromLocation(fromLocation);
        tripBooking.setToLocation(toLocation);
        tripBooking.setDistanceInKm(distanceInKm);

        int rateperkm = driver.getCab().getPerKmRate();

        tripBooking.setBill(distanceInKm*10);

        tripBooking.setStatus(TripStatus.CONFIRMED);

        driver.getTripBookingList().add(tripBooking);
        driverRepository.save(driver);

        return tripBooking;



    }

    public  String cancelTrip(int tripId){
        TripBooking tripBooking = tripBookingRepository.findById(tripId).get();
        tripBooking.setStatus(TripStatus.CANCELED);
        tripBooking.setBill(0);
        tripBooking.getDriver().getCab().setAvailable(Boolean.TRUE);

        tripBookingRepository.save(tripBooking);
        return "trip is cancelled";
    }

    public void completeTrip(Integer tripId){
        //Complete the trip having given trip Id and update TripBooking attributes accordingly
        //set bill and status
        TripBooking tripBooking = tripBookingRepository.findById(tripId).get();
        tripBooking.setStatus(TripStatus.COMPLETED);
        int bill = tripBooking.getDriver().getCab().getPerKmRate()*tripBooking.getDistanceInKm();
        tripBooking.setBill(bill);
        tripBooking.getDriver().getCab().setAvailable(Boolean.TRUE);
        tripBookingRepository.save(tripBooking);
    }


}
