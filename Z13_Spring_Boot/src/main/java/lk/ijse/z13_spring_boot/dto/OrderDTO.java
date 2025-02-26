package lk.ijse.z13_spring_boot.dto;

import java.util.List;

public class OrderDTO {
    private int customerId;
    private double totalPrice;
    private List<OrderDetailDTO> orderDetails;

    public OrderDTO() {
    }

    public OrderDTO(int customerId, double totalPrice, List<OrderDetailDTO> orderDetails) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.orderDetails = orderDetails;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
