package jay;

import jay.bean.Emp;
import jay.factory_demo.Book;
import jay.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

    // 1、外部bean
    @Test
    public void testBean1(){
        // 加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");

        // 获取配置创建的对象
        UserService userService = context.getBean("userServicr", UserService.class);
        userService.add();
    }

    // 2、内部bean
    @Test
    public void testBean2(){
        // 加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");

        // 获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }

    // 3、级联赋值
    @Test
    public void testBean3(){
        // 加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");

        // 获取配置创建的对象
        Emp emp = context.getBean("emp1", Emp.class);
        emp.add();
    }
}
