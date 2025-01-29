package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    public HelloController() {
        System.out.println("Hello Controller called!");
    }

    /*Mapping Method Or Handler Method*/
    @GetMapping
    public String hello(){
        return "hello World";
    }
}
