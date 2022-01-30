package rdjaramillo1.ms.store.servicecustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rdjaramillo1.ms.store.servicecustomer.entity.Customer;
import rdjaramillo1.ms.store.servicecustomer.entity.Region;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    public Customer findByNumberID(String numberID);
    public List <Customer> findByLastName(String lastName);
    public List<Customer> findByRegion(Region region);

}
