package lk.ijse;

import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
   /*     Map<String, String> getEnv = System.getenv();
        for (String key : getEnv.keySet()) {
            System.out.println(key + " " + getEnv.get(key));
        }*/

        /*Properties properties = System.getProperties();
        for(String key : properties.stringPropertyNames()){
            System.out.println(key + " " + properties.get(key));
        }*/

        context.registerShutdownHook();
    }
}
