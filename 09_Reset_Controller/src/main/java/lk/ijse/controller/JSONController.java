package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("json")
public class JSONController {

    @PostMapping
    public String customerSave(@RequestBody CustomerDTO customerDTO){
        return customerDTO.toString();
    }


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerDTO customerGet(){
        return new CustomerDTO("Nimal", "Perera", 25);
    }

    @GetMapping(path = "data", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<CustomerDTO> customerDTOArrayList(){
        ArrayList<CustomerDTO> list = new ArrayList<>();
        list.add(new CustomerDTO("Nimal", "Perera", 25));
        list.add(new CustomerDTO("Kamal", "Perera", 25));
        list.add(new CustomerDTO("Chamal", "Perera", 25));
        return list;
    }
}
