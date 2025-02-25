package lk.ijse.z13_spring_boot.controller;

import lk.ijse.z13_spring_boot.dto.OrderDTO;
import lk.ijse.z13_spring_boot.service.impl.OrderServiceImpl;
import lk.ijse.z13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin("*")
public class PlaceOrderFormController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @PostMapping("/place")
    public ResponseUtil placeOrder(@RequestBody OrderDTO orderDTO) {
        orderServiceImpl.placeOrder(orderDTO);
        return new ResponseUtil(201, "Order Place Successfully!", null);
    }
}
