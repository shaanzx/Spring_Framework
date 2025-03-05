package lk.ijse.spring_boot_logins.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @GetMapping
    public String logDemo(){
        log.trace("This is a trace log message");
        log.debug("This is a debug log message");
        log.info("This is an info log message");
        log.warn("This is a warn log message");
        log.error("This is an error logging message");
        return "Hello";
    }
}
