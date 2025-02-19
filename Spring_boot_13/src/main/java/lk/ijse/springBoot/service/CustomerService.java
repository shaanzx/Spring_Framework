package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.CustomerDTO;
import lk.ijse.springBoot.entity.Customer;
import lk.ijse.springBoot.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public boolean saveCustomer(CustomerDTO customerDTO) {
        try {
            customerRepo.save(new Customer(
                    customerDTO.getId(),
                    customerDTO.getName(),
                    customerDTO.getAddress()
            ));
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error saving customer: " + e.getMessage());
        }
    }

    public boolean updateCustomer(CustomerDTO customerDTO) {
        try {
            Optional<Customer> optionalCustomer = customerRepo.findById(customerDTO.getId());
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                customer.setName(customerDTO.getName());
                customer.setAddress(customerDTO.getAddress());
                customerRepo.save(customer);
                return true;
            } else {
                throw new RuntimeException("Customer not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating customer: " + e.getMessage());
        }
    }

    public boolean deleteCustomer(int id) {
        try {
            Optional<Customer> optionalCustomer = customerRepo.findById(id);
            if (optionalCustomer.isPresent()) {
                customerRepo.deleteById(id);
                return true;
            } else {
                throw new RuntimeException("Customer not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting customer: " + e.getMessage());
        }
    }

    public List<CustomerDTO> getCustomers() {
        try {
            List<Customer> customers = customerRepo.findAll();
            List<CustomerDTO> customerDTOS = new ArrayList<>();
            for (Customer customer : customers) {
                customerDTOS.add(new CustomerDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getAddress()
                ));
            }
            return customerDTOS;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving customers: " + e.getMessage());
        }
    }
}
