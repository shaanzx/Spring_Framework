package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConfigOne.class})
public class AppConfig {
    @Bean
    public SpringBean springBean(){
        return new SpringBean();
    }
}
