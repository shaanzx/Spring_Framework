package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
   /* @Autowired(required = false)
    public SpringBean(@Value("Shan") String name, @Value("1") int id, @Value("true")boolean isActive) {
        System.out.println("Spring Bean Object Created");
        System.out.println(id + " " + name+" "+isActive);
    }

    @Autowired(required = false)
    public SpringBean(@Value("Shan") String name, @Value("1") int id) {
        System.out.println("Spring Bean Object Created");
        System.out.println(id + " " + name);
    }*/
    @Value("Shan")
    private String name;

    public SpringBean() {
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }
}
