package org.example.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBean{
    public SpringBean() {
        System.out.println("Spring Bean Object Created");
    }
    public void testBean(){
        System.out.println("Test Method");
    }
}
