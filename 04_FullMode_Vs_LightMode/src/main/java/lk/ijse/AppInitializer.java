package lk.ijse;

import lk.ijse.bean.SpringBeanOne;
import lk.ijse.bean.SpringBeanTwo;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        context.registerShutdownHook();

/*        SpringBeanOne bean = context.getBean(SpringBeanOne.class);
        System.out.println(bean);
        SpringBeanOne bean2 = context.getBean(SpringBeanOne.class);
        System.out.println(bean2);

        SpringBeanTwo bean3 = context.getBean(SpringBeanTwo.class);
        System.out.println(bean3);
        SpringBeanTwo bean4 = context.getBean(SpringBeanTwo.class);
        System.out.println(bean4);*/

        SpringBeanTwo bean = context.getBean(SpringBeanTwo.class);
        SpringBeanTwo bean2 = context.getBean(SpringBeanTwo.class);

/*        System.out.println(bean);
        System.out.println(bean2);*/
    }
}
