package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.CustomerDTO;
import lk.ijse.springBoot.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public boolean saveCustomer(CustomerDTO customerDTO) {
        System.out.println("Service Layer: "+ customerDTO.getName());
        return true;
    }
}
