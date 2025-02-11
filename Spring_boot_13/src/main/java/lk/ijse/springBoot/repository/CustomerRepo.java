package lk.ijse.springBoot.repository;

import lk.ijse.springBoot.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> { // Add diamond bracket to Entity class name and it primary ID data type

}
