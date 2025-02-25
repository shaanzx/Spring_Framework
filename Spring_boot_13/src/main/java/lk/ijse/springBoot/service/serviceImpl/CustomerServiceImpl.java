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
    public void saveCustomer(CustomerDTO customerDTO) {
            /*customerRepo.save(new Customer(
                    customerDTO.getId(),
                    customerDTO.getName(),
                    customerDTO.getAddress()*/
            if(customerRepo.existsById(customerDTO.getId())){
                throw new RuntimeException("Customer already exists");
            }
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

            Optional<Customer> optionalCustomer = customerRepo.findById(customerDTO.getId());
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                modelMapper.map(customerDTO, customer);
                customerRepo.save(customer);

            } else {
                throw new RuntimeException("Customer not found");
            }
    }

    @Override
    public void deleteCustomer(int id) {

            Optional<Customer> optionalCustomer = customerRepo.findById(String.valueOf(id));
            if (optionalCustomer.isPresent()) {
                customerRepo.deleteById(String.valueOf(id));
            } else {
                throw new RuntimeException("Customer not found");
            }
    }

    @Override
    public List<CustomerDTO> getCustomers() {
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
    }
}
