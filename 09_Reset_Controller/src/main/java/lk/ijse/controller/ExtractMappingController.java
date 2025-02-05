package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extract")
public class ExtractMappingController {
    @GetMapping(path = "test1")
    public String extractMapping(){
        return "Extract test1  Mapping";
    }

    @GetMapping(path = "test2")
    public String extractMapping2(){
        return "Extract test2  Mapping";
    }

    @GetMapping(path = "test3")
    public String extractMapping3(){
        return "Extract test3  Mapping";
    }
}
