package uber.example.uber.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uber.example.uber.model.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {

}
