package org.example;


import org.example.bean.Boy;
import org.example.config.AppConfig;
import org.example.di.Test2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        Test2 test2 = context.getBean(Test2.class);
        test2.display();

        context.registerShutdownHook();
    }
}
