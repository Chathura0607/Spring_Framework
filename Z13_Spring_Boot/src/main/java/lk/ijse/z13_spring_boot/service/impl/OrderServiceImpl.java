package lk.ijse.z13_spring_boot.service.impl;

import lk.ijse.z13_spring_boot.dto.OrderDTO;
import lk.ijse.z13_spring_boot.entity.Customer;
import lk.ijse.z13_spring_boot.entity.Item;
import lk.ijse.z13_spring_boot.entity.Order;
import lk.ijse.z13_spring_boot.entity.OrderDetail;
import lk.ijse.z13_spring_boot.repo.CustomerRepo;
import lk.ijse.z13_spring_boot.repo.ItemRepo;
import lk.ijse.z13_spring_boot.repo.OrderDetailRepo;
import lk.ijse.z13_spring_boot.repo.OrderRepo;
import lk.ijse.z13_spring_boot.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepo orderRepo, OrderDetailRepo orderDetailRepo,
                            CustomerRepo customerRepo, ItemRepo itemRepo, ModelMapper modelMapper) {
        this.orderRepo = orderRepo;
        this.orderDetailRepo = orderDetailRepo;
        this.customerRepo = customerRepo;
        this.itemRepo = itemRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void placeOrder(OrderDTO orderDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(orderDTO.getCustomerId());
        Customer customer = optionalCustomer.orElseThrow(() -> new RuntimeException("Customer not found!"));

        Order order = modelMapper.map(orderDTO, Order.class);
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now().toString());

        List<OrderDetail> orderDetailsList = orderDTO.getOrderDetails().stream().map(detailDTO -> {
            Optional<Item> optionalItem = itemRepo.findById(detailDTO.getItemId());
            Item item = optionalItem.orElseThrow(() -> new RuntimeException("Item not found!"));

            if (item.getQty() < detailDTO.getQuantity()) {
                throw new RuntimeException("Not enough stock for item: " + item.getName());
            }

            // Reduce stock
            item.setQty(item.getQty() - detailDTO.getQuantity());
            itemRepo.save(item);

            OrderDetail orderDetail = modelMapper.map(detailDTO, OrderDetail.class);
            orderDetail.setOrder(order);
            orderDetail.setItem(item);
            return orderDetail;
        }).collect(Collectors.toList());

        order.setOrderDetails(orderDetailsList);
        orderRepo.save(order);
        orderDetailRepo.saveAll(orderDetailsList);

    }
}
