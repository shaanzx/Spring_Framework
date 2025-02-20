package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(int id);

    List<CustomerDTO> getCustomers();
}
