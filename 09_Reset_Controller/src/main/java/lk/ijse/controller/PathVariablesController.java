package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("variable")
public class PathVariablesController {

    @GetMapping(path = "{id:[I][0-9]{3}}")
    public String variable1(@PathVariable String id){
        return id;
    }

    @GetMapping(path = "{customerId}")
    public String variable2(@PathVariable("customerId") String id){
        return id;
    }

    @GetMapping(path = "{customerId}/{customerName}")
    public String variable3(@PathVariable("customerId") String id, @PathVariable("customerName") String name){
        return id+" "+name;
    }


}
