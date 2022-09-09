package jay.factory_demo;

import jay.Main;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloFactory {

    public static void nibuhao() {
        System.out.println("Hello No World");
    }

    // 工厂的实现方式
    public static HelloWord getword() {
        return new HelloWord();
    }
}
