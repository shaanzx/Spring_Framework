package lk.ijse.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanThree implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("Spring Bean Three Name : "+ name);
    }
}
