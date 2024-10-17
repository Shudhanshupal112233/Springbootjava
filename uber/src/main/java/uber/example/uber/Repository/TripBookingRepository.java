package uber.example.uber.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uber.example.uber.model.TripBooking;

public interface TripBookingRepository extends JpaRepository<TripBooking,Integer> {
}
