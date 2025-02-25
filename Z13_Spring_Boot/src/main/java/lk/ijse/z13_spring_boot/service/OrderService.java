package lk.ijse.z13_spring_boot.service;

import lk.ijse.z13_spring_boot.dto.OrderDTO;

public interface OrderService {
    void placeOrder(OrderDTO orderDTO);
}

