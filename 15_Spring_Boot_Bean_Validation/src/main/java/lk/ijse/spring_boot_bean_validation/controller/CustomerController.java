package lk.ijse.spring_boot_bean_validation.controller;

import jakarta.validation.Valid;
import lk.ijse.spring_boot_bean_validation.dto.CustomerDTO;
import lk.ijse.spring_boot_bean_validation.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        ResponseDTO responseDTO = new ResponseDTO(
                "User Saved Successfully",
                HttpStatus.CREATED.value(),
                customerDTO
        );
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
}
