package lk.ijse.springBoot.service.serviceImpl;

import lk.ijse.springBoot.dto.CustomerDTO;
import lk.ijse.springBoot.dto.OrderDTO;
import lk.ijse.springBoot.entity.Customer;
import lk.ijse.springBoot.entity.Order;
import lk.ijse.springBoot.repository.CustomerRepo;
import lk.ijse.springBoot.repository.OrderRepo;
import lk.ijse.springBoot.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        if (orderRepo.existsById(orderDTO.getOrderId())) {
            throw new RuntimeException("Order already exists");
        }

        Customer customer = modelMapper.map(orderDTO.getCustomer(), Customer.class);

        Order order = modelMapper.map(orderDTO, Order.class);
        order.setCustomer(customer);
        orderRepo.save(order);
    }

    @Override
    public List<OrderDTO> getOrder() {
        return modelMapper.map(orderRepo.findAll(), new TypeToken<List<OrderDTO>>() {}.getType());
    }

    @Override
    public OrderDTO getOrderById(String id) {
        Order order = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return modelMapper.map(order, OrderDTO.class);
    }
}