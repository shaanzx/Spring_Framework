package lk.ijse.springBoot.controller;

import lk.ijse.springBoot.dto.CustomerDTO;
import lk.ijse.springBoot.entity.Customer;
import lk.ijse.springBoot.repository.CustomerRepo;
import lk.ijse.springBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/customer", produces = "application/json", consumes = "application/json")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping(path = "/save")
    public boolean getCustomer(@RequestBody CustomerDTO customerDTO) {
        customerRepo.save(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        ));
        return true;
    }
}
