package org.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean,DisposableBean {
    public MyConnection() {
        System.out.println("MyConnection Object Created");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("MyConnection Bean Name Set");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyConnection Bean Factory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyConnection Application Context");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyConnection Initializing Bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection Disposing Bean");
    }
}
