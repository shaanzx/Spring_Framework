package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("two")
public class WildCardMappingOptionTwo {

   // @GetMapping(path = "test/**/hello")
    public String test1() {
        return "ExtractMappingTwo test1";
    }
}
