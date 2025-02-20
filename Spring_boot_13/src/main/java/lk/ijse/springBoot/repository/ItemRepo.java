package lk.ijse.springBoot.repository;

import lk.ijse.springBoot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer> {
}
