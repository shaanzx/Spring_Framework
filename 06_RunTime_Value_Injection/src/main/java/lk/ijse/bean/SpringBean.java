package lk.ijse.bean;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {
    public SpringBean(String name) {
        System.out.println("Spring Bean Object Created");
    }
}
