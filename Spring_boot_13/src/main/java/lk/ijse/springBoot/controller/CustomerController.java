package lk.ijse.springBoot.controller;

import lk.ijse.springBoot.dto.CustomerDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/customer",produces = "application/json", consumes = "application/json")
public class CustomerController {
    @PostMapping(path = "/save")
    public CustomerDTO getCustomer(@RequestBody CustomerDTO customerDTO){
        return customerDTO;
    }
}
