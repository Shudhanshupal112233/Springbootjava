package uber.example.uber.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uber.example.uber.model.Cab;
@Repository
public interface CabRepository extends JpaRepository<Cab,Integer> {
}
