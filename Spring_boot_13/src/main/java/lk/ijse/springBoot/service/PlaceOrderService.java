package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.OrderDTO;

public interface PlaceOrderService {
    void placeOrder(OrderDTO orderDTO);
}