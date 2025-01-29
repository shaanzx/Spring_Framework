package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
    @Value("${os.name}")
    private String osName;

    @Value("${USERNAME}")
    private String userName;

    @Value("${DB_USER}")
    private String dbUser;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("OS Name : " + osName);
        System.out.println("User Name : " + userName);
        System.out.println("DB User Name : "+ dbUser);
    }
}
