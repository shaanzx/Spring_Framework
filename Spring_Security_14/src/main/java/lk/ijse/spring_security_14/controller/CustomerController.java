package lk.ijse.spring_security_14.controller;

import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.spring_security_14.dto.CustomerDTO;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private List<CustomerDTO> customerList = new ArrayList<CustomerDTO>(
            List.of(new CustomerDTO("shan",22),
                    new CustomerDTO("Lakshan",24))
    );

    @GetMapping
    public List<CustomerDTO> getAllCustomers(){
        return customerList;
    }

    @PostMapping
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerList.add(customerDTO);
        return "Customer Saved";
    }

    @GetMapping("csrftoken")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
