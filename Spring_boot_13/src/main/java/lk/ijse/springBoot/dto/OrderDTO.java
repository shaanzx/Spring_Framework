package lk.ijse.springBoot.dto;

import java.util.Date;

public class OrderDTO {
    private String orderId;
    private Date orderDate;
    private CustomerDTO customer;

    public OrderDTO() {}

    public OrderDTO(String orderId, Date orderDate, CustomerDTO customer) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}