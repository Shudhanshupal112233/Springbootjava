package uber.example.uber.Repository;

import org.springframework.stereotype.Repository;
import uber.example.uber.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
