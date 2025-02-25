package lk.ijse.z13_spring_boot.dto;

public class OrderDetailDTO {
    private int itemId;
    private double quantity;
    private double unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int itemId, double quantity, double unitPrice) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}