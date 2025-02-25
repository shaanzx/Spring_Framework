package lk.ijse.springBoot.controller;

import lk.ijse.springBoot.dto.OrderDTO;
import lk.ijse.springBoot.service.OrderService;
import lk.ijse.springBoot.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveOrder(@RequestBody OrderDTO orderDTO) {
        orderService.saveOrder(orderDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response("Order saved successfully", HttpStatus.CREATED));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOrder(@PathVariable String id) {
        OrderDTO orderDTO = orderService.getOrderById(id); // Assume this method exists
        return ResponseEntity
                .ok(new Response("Order retrieved successfully", HttpStatus.OK, orderDTO));
    }

    @GetMapping("/get")
    public ResponseEntity<Response> getAllOrders() {
        List<OrderDTO> orders = orderService.getOrder();
        return ResponseEntity
                .ok(new Response("Orders retrieved successfully", HttpStatus.OK, orders));
    }
}