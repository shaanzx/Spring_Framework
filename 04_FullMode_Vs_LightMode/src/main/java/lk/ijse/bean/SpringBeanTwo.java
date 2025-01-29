package lk.ijse.bean;

import org.springframework.beans.factory.BeanNameAware;

public class SpringBeanTwo implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("Spring Bean Two Name : "+name);
    }
/*    public SpringBeanTwo() {
        System.out.println("Spring Bean Two Constructor Called");
    }*/


}
