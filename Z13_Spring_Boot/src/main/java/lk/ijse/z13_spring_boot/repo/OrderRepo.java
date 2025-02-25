package lk.ijse.z13_spring_boot.repo;

import lk.ijse.z13_spring_boot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
