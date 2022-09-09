package jay.spring.Main;

import jay.spring.autowrite.Emp;
import jay.spring.beanlife.Orders;
import jay.spring.collectiontype.Book;
import jay.spring.collectiontype.Course;
import jay.spring.collectiontype.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test
    public void testStudent(){
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2、获取配置创建的对象
        Student student = context.getBean("stu", Student.class);
        student.test();
    }

    @Test
    public void testBook(){
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");

        // 2、获取配置创建的对象
        Book book = context.getBean("book", Book.class);
        book.test();
    }

    @Test
    public void testFactoryBean(){
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");

        // 2、获取配置创建的对象
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void testBeanLife(){
        // 1、加载Spring配置文件
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean3.xml");
        // 2、获取配置创建的对象
        System.out.println("第四步 获取创建bean实例对象");
        Orders order = context.getBean("orders", Orders.class);
        System.out.println(order);

        System.out.println("手动让bean实例销毁");
        context.close();
    }

    @Test
    public void testAutoWrite(){
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean4.xml");
        // 2、获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        emp.test();
        System.out.println(emp);
    }
}
