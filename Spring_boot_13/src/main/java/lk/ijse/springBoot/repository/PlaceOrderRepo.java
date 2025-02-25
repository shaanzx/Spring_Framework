package lk.ijse.springBoot.repository;

import lk.ijse.springBoot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceOrderRepo extends JpaRepository<Order, String> {
}