package lk.ijse.springBoot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemCode;
    private int qty;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order orderId;

    public OrderDetails() {}

    public OrderDetails(String itemCode, int qty, double price, Order orderId) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.price = price;
        this.orderId = orderId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }
}