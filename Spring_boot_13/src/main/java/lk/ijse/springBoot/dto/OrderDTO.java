package lk.ijse.springBoot.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private String orderId;
    private String customerId;
    private Date orderDate;
    private double total;
    private List<OrderDetailsDTO> items;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String customerId, Date orderDate, double total, List<OrderDetailsDTO> items) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.total = total;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderDetailsDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderDetailsDTO> items) {
        this.items = items;
    }
}