package com.jay;

import com.jay.bean.Pet;
import com.jay.bean.User;
import com.jay.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 *
 * @author Administrator
 * @SpringBootApplication： 这是一个SpringBoot应用
 * scanBasePackages: 改变扫描路径
 */

@SpringBootApplication(scanBasePackages = "com.jay")
public class MainApplication {
    public static void main(String[] args) {
        // 1、返回我们的IOC容器
        ConfigurableApplicationContext run =
                SpringApplication.run(MainApplication.class, args);

        // 2、查看容器里面的组件
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names){
//            System.out.println(name);
//        }

        // 3、从容器中获取组件（是单实例对象）
        Pet tom1 = run.getBean("tom", Pet.class);
        Pet tom2 = run.getBean("tom", Pet.class);
        System.out.println("tom1 = tom2: " + (tom1 == tom2));

        // 4、获取配置类组件（配置类里的组件设置为了多实例对象）
        MyConfig bean = run.getBean(MyConfig.class);
        User user1 = bean.user01();
        User user2 = bean.user01();
        System.out.println("user1 = user2: " + (user1 == user2));

        // 5、条件装配，containsBean判断是否包含某个组件
        boolean user01 = run.containsBean("user01");
        System.out.println("user01: " + user01);

        boolean tom = run.containsBean("tom");
        System.out.println("tom: " + tom);

        int min = 625 + 23 + 19 + 22;
        int sec = 1223 + 31 + 43 + 28;
        System.out.println(min + (sec / 60));
    }
}
