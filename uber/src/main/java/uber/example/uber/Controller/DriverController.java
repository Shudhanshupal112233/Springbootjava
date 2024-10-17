package uber.example.uber.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uber.example.uber.Services.DriverService;
import uber.example.uber.model.Driver;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/add")
    public String adddriver(@RequestBody Driver driver){
        String result = driverService.adddriver(driver);
        return  result;
    }

    @DeleteMapping("/delete")
    public void deletecustomer(@RequestParam Integer driverId){
        driverService.deletedriver( driverId);

    }

    @PutMapping("/status")
    public void updateStatus(@RequestParam Integer driverId){
        driverService.updatestatus(driverId);
    }
}
