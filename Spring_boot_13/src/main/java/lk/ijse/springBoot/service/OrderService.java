package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    List<OrderDTO> getOrder();
    OrderDTO getOrderById(String id);
}