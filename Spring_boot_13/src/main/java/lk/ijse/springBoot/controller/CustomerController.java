package lk.ijse.springBoot.controller;

import lk.ijse.springBoot.dto.CustomerDTO;
import lk.ijse.springBoot.service.CustomerService;
import lk.ijse.springBoot.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveCustomer(@RequestBody CustomerDTO customerDTO) {
            customerService.saveCustomer(customerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Customer saved successfully",  HttpStatus.OK));
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return ResponseEntity.ok(new Response("Customer updated successfully", HttpStatus.CREATED));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable int id) {
            customerService.deleteCustomer(id);
            return ResponseEntity.ok(new Response("Customer deleted successfully", HttpStatus.OK));
    }

    @GetMapping("/get")
    public ResponseEntity<Response> getCustomers() {
            List<CustomerDTO> customers = customerService.getCustomers();
            return ResponseEntity.ok(new Response("Customers retrieved successfully", HttpStatus.OK, customers));
    }
}
