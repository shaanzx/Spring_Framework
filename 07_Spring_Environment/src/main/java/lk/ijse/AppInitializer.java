package lk.ijse;

import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        Map<String, String> getEnv = System.getenv();
        for (String key : getEnv.keySet()) {
            System.out.println(key + " " + getEnv.get(key));
        }

        context.registerShutdownHook();
    }
}
