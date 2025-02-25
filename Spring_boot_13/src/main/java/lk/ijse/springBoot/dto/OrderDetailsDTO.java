package lk.ijse.springBoot.dto;

public class OrderDetailsDTO {
    private String itemCode;
    private int qty;
    private double price;
    private String orderId;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String itemCode, int qty, double price, String orderId) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.price = price;
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}