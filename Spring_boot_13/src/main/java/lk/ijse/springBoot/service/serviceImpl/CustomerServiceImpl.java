package lk.ijse.springBoot.service.serviceImpl;

import lk.ijse.springBoot.dto.CustomerDTO;
import lk.ijse.springBoot.entity.Customer;
import lk.ijse.springBoot.repository.CustomerRepo;
import lk.ijse.springBoot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        try {
            /*customerRepo.save(new Customer(
                    customerDTO.getId(),
                    customerDTO.getName(),
                    customerDTO.getAddress()*/
            if(customerRepo.existsById(customerDTO.getId())){
                throw new RuntimeException("Customer already exists");
            }
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error saving customer: " + e.getMessage());
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        try {
            Optional<Customer> optionalCustomer = customerRepo.findById(customerDTO.getId());
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                modelMapper.map(customerDTO, customer);
                customerRepo.save(customer);
                return true;
            } else {
                throw new RuntimeException("Customer not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating customer: " + e.getMessage());
        }
    }

    @Override
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

    @Override
    public List<CustomerDTO> getCustomers() {
        try {
            /*List<Customer> customers = customerRepo.findAll();
            List<CustomerDTO> customerDTOS = new ArrayList<>();
            for (Customer customer : customers) {
                customerDTOS.add(new CustomerDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getAddress()
                ));
            }
            return customerDTOS;*/
            return  modelMapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving customers: " + e.getMessage());
        }
    }
}
