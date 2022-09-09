package jay.spring.Main;


import jay.spring.entity.Book;
import jay.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Test
    public void testJdbcTemplate(){    // 全注解开发
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2、获取配置创建的对象
        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();
        book.setBookId("1");
        book.setBookName("java");
        book.setbStatus("1");
        bookService.addBook(book);
//        System.out.println((172+126+133+ 8+14));
//        System.out.println((238+228+310+ 3+ 6)/60);
//        user.add();
    }

}
