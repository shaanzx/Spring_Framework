package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    boolean saveCustomer(CustomerDTO customerDTO);

    boolean updateCustomer(CustomerDTO customerDTO);

    boolean deleteCustomer(int id);

    List<CustomerDTO> getCustomers();
}
