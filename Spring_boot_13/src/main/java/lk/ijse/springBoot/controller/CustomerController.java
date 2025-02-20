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
@RequestMapping(value = "api/v1/customer", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            boolean isSaved = customerService.saveCustomer(customerDTO);
            if (isSaved) {
                return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Customer saved successfully",  HttpStatus.OK));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Failed to save customer", HttpStatus.NOT_FOUND));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Error saving customer: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            boolean isUpdated = customerService.updateCustomer(customerDTO);
            if (isUpdated) {
                return ResponseEntity.ok(new Response("Customer updated successfully", HttpStatus.CREATED));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Customer not found", HttpStatus.NOT_FOUND));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Error updating customer: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable int id) {
        try {
            boolean isDeleted = customerService.deleteCustomer(id);
            if (isDeleted) {
                return ResponseEntity.ok(new Response("Customer deleted successfully", HttpStatus.OK));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Customer not found", HttpStatus.NOT_FOUND));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Error deleting customer: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Response> getCustomers() {
        try {
            List<CustomerDTO> customers = customerService.getCustomers();
            return ResponseEntity.ok(new Response("Customers retrieved successfully", HttpStatus.OK, customers));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Error retrieving customers: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }
}
