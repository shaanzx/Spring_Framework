package org.example;


import org.example.bean.MyConnection;
import org.example.bean.SpringBean;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        MyConnection myConnection1 = context.getBean(MyConnection.class);
        System.out.println("----------------");
        MyConnection myConnection2 = context.getBean(MyConnection.class);



        context.registerShutdownHook();


    }
}
