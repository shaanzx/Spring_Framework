package lk.ijse.spring_security_14.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HelloController {

    @GetMapping
    public String hello(HttpServletRequest request) {
        return "Hello : " + request.getSession().getId();
    }
}
