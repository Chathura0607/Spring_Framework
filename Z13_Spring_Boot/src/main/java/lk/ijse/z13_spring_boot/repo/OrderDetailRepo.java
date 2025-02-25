package lk.ijse.z13_spring_boot.repo;

import lk.ijse.z13_spring_boot.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
}
