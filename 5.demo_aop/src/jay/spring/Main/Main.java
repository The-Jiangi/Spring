package jay.spring.Main;

import jay.spring.aopanno.User;
import jay.spring.config.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Test
    public void testAop(){    // 全注解开发
        // 1、加载Spring配置文件
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigAop.class);

        // 2、获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println((172+126+133+ 8+14));
        System.out.println((238+228+310+ 3+ 6)/60);
        user.add();
    }

}
