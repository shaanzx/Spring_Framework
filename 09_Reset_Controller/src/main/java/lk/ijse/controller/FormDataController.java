package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("form")
public class FormDataController {

    /* This is use for get the data from the form*/
    @PostMapping
    public String test1(@ModelAttribute CustomerDTO customerDTO){
        System.out.println(customerDTO.getFirstName());
        return customerDTO.toString();
    }
}
