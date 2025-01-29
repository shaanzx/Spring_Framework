package lk.ijse.config;

import lk.ijse.bean.SpringBeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigOne {
    @Bean
    public SpringBeanOne springBeanOne(){
        return new SpringBeanOne();
    }
}
