package jay;

import jay.factory_demo.Book;
import jay.factory_demo.HelloFactory;
import jay.factory_demo.HelloWord;
import jay.factory_demo.Orders;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        HelloWord hw = HelloFactory.getword();
        hw.nihao();
    }

    @Test
    public void testHolloWord(){
        // 1、加载Spring配置文件  ApplicationContext比BeanFactory功能更强大
        // BeanFactory context =
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2、获取配置创建的对象
        HelloWord hw = context.getBean("hw", HelloWord.class);
        hw.nihao();
        HelloFactory hnw = context.getBean("hf", HelloFactory.class);
        hnw.nibuhao();
    }

    @Test
    public void testBook1(){
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2、获取配置创建的对象
        Book book = context.getBean("book1", Book.class);
        book.testDemo();
    }

    @Test
    public void testBook2(){
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2、获取配置创建的对象
        Book book = context.getBean("book2", Book.class);
        book.testDemo();
    }

    @Test
    public void testOrder(){
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2、获取配置创建的对象
        Orders order = context.getBean("orders", Orders.class);
        order.orderTest();
    }

}
