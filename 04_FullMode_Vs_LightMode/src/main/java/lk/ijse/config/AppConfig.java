package lk.ijse.config;


import lk.ijse.bean.SpringBeanOne;
import lk.ijse.bean.SpringBeanThree;
import lk.ijse.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {
/*    @Bean
    public SpringBeanOne getSpringBeanOne() {
        //Inter Bean Dependency

        SpringBeanTwo s1 = getSpringBeanTwo();
        SpringBeanTwo s2 = getSpringBeanTwo();
        return new SpringBeanOne();
    }

    @Bean
    public SpringBeanTwo getSpringBeanTwo() {
        return new SpringBeanTwo();
    }*/

    /*@Bean
    public SpringBeanTwo getSpringBeanTwo() {
        SpringBeanThree bean = getSpringBeanThree();
        SpringBeanThree bean2 = getSpringBeanThree();
        return new SpringBeanTwo();
    }

    @Bean
    public SpringBeanThree getSpringBeanThree() {
        return new SpringBeanThree();
    }*/

}
