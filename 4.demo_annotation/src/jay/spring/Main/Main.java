package jay.spring.Main;

import jay.spring.config.SpringConfig;
import jay.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    
    @Test
    public void test1(){
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2、获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);
        userService.add();
    }

    @Test
    public void test2(){    // 全注解开发
        // 1、加载Spring配置文件
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        // 2、获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }

}
