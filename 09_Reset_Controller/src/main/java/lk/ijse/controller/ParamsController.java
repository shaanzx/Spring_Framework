package lk.ijse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("params")
public class ParamsController {
    @GetMapping(params = {"id", "name"} )
    public String test(@RequestParam(value = "id", required = false) String id,
                       @RequestParam(value = "name", required = false) String name) {
         return id+" "+name;
    }
}
