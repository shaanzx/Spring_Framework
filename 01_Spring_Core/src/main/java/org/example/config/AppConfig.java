package org.example.config;

import org.example.bean.MyConnection;
import org.example.bean.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig {
    @Bean("connection")
    @Scope("prototype")
    MyConnection getConnection() {
        return new MyConnection();

        //cross cutting concerns
        //concerns
        //aspect and template
        //aspect oriented programming ->
            //aspect,join point,advice,pointcut,weaving
        //declarative programming
        //POJO vs Beans
        //Bean Factory
        //Application Context
        //Common Conventions
        //annotations
            //configuration,component,componentscan,bean,scope
    }
}
