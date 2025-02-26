package lk.ijse.springBoot.service.serviceImpl;

import lk.ijse.springBoot.dto.OrderDTO;
import lk.ijse.springBoot.dto.OrderDetailsDTO;
import lk.ijse.springBoot.entity.Item;
import lk.ijse.springBoot.entity.Order;
import lk.ijse.springBoot.entity.OrderDetails;
import lk.ijse.springBoot.repository.ItemRepo;
import lk.ijse.springBoot.repository.OrderDetailsRepo;
import lk.ijse.springBoot.repository.OrderRepo;
import lk.ijse.springBoot.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void placeOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        orderRepo.save(order);

        for (OrderDetailsDTO detailDTO : orderDTO.getItems()) {
            OrderDetails orderDetail = modelMapper.map(detailDTO, OrderDetails.class);
            orderDetail.setOrderId(order);
            orderDetailsRepo.save(orderDetail);

            Optional<Item> optionalItem = itemRepo.findById(detailDTO.getItemCode());
            if (optionalItem.isPresent()) {
                Item item = optionalItem.get();
                item.setQtyOnHand(item.getQtyOnHand() - detailDTO.getQty());
                itemRepo.save(item);
            } else {
                throw new RuntimeException("Item not found: " + detailDTO.getItemCode());
            }
        }
    }
}