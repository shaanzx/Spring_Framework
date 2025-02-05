package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hello() {
        return "Get Mapping";
    }

    @PostMapping
    public String helloPost() {
        return "Post Mapping";
    }

    @PutMapping
    public String helloPut() {
        return "Put Mapping";
    }

    @DeleteMapping
    public String helloDelete() {
        return "Delete Mapping";
    }

    @PatchMapping
    public String helloPatch() {
        return "Patch Mapping";
    }
}
