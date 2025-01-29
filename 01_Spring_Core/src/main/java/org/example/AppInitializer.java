package org.example;

import org.example.bean.MyConnection;
import org.example.bean.SpringBean;
import org.example.bean.TestBean1;
import org.example.bean.TestBean2;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        TestBean1 ref1 = context.getBean("testBean1", TestBean1.class);
        TestBean1 ref2 = context.getBean("testBean1", TestBean1.class);
        System.out.println(ref1);
        System.out.println(ref2);

        TestBean2 ref3 = context.getBean("testBean2", TestBean2.class);
        TestBean2 ref4 = context.getBean("testBean2", TestBean2.class);
        System.out.println(ref3);
        System.out.println(ref4);

        MyConnection ref5 = context.getBean("connection", MyConnection.class);
        MyConnection ref6 = context.getBean("connection", MyConnection.class);
        System.out.println(ref5);
        System.out.println(ref6);

        context.registerShutdownHook();


    }
}
