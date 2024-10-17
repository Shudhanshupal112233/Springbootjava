package uber.example.uber.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uber.example.uber.Repository.CabRepository;
import uber.example.uber.Repository.DriverRepository;
import uber.example.uber.model.Cab;
import uber.example.uber.model.Customer;
import uber.example.uber.model.Driver;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository1;

    @Autowired
    CabRepository cabRepository1;


    public  String adddriver(Driver driver){
        driverRepository1.save(driver);
        Cab cab = new Cab();
        cab.setDriver(driver);
        cab.setAvailable(Boolean.TRUE);
        cab.setPerKmRate(10);
        cabRepository1.save(cab);
        return  "added succefully";

    }


    public String deletedriver(Integer driverId){

        Driver driver = driverRepository1.findById(driverId).get();
        driverRepository1.delete(driver);
        return "deleted";

    }


    public void updatestatus(Integer driverId){

        Driver driver = driverRepository1.findById(driverId).get();
        Cab cab = driver.getCab();

        cab.setAvailable(Boolean.FALSE);
        cabRepository1.save(cab);
    }


}
