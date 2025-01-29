package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanOne implements BeanNameAware, ApplicationContextAware {
/*    public SpringBeanOne() {
        System.out.println("Spring Bean One Constructor Called");
    }*/

    @Bean
    public SpringBeanTwo getSpringBeanTwo() {
        SpringBeanThree springBeanThree = getSpringBeanThree();
        SpringBeanThree springBeanThree1 = getSpringBeanThree();

        System.out.println(springBeanThree);
        System.out.println(springBeanThree1);

        return new SpringBeanTwo();
    }

    @Bean
    public SpringBeanThree getSpringBeanThree() {
        return new SpringBeanThree();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Spring Bean One Name : "+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Spring Bean One Application Context");
    }
}
