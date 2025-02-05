package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("one")
public class WildCardMappingOptionOne {

    @GetMapping(path = "test/*/hello")
    public String test(){
        return "Get Mapping Option One";
    }
}
