package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    ArrayList<CustomerDTO> customer = new ArrayList<>();

    @PostMapping("save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        customer.add(customerDTO);
        return customerDTO;
    }

    @PutMapping("update")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        for(int i=0;i<customer.size();i++){
            CustomerDTO existingCustomer = customer.get(i);
            if(existingCustomer.getId().equals(customerDTO.getId())){
                existingCustomer.setName(customerDTO.getName());
                existingCustomer.setAddress(customerDTO.getAddress());
                existingCustomer.setAge(customerDTO.getAge());
                return existingCustomer;
            }
        }
        return customerDTO;
    }

    @GetMapping("getAll")
    public List<CustomerDTO> getAllCustomers() {
        return customer;
    }

    @DeleteMapping(path = {"delete/{id}"})
    public boolean deleteCustomer(@PathVariable(value = "id" ) String id){
        for(int i=0;i<customer.size();i++){
            CustomerDTO existingCustomer = customer.get(i);
            if(existingCustomer.getId().equals(id)){
                customer.remove(i);
                return true;
            }
        }
        return false;
    }
}
