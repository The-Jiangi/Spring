package jay.spring;


import jay.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    @Test
    public void testJdbcTemplate(){    // 全注解开发
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2、获取配置创建的对象
        BookService bookService = context.getBean("bookService", BookService.class);

        // 添加
//        Book book = new Book();
//        book.setBookId("1");
//        book.setBookName("java");
//        book.setbStatus("1");
//        bookService.addBook(book);

        // 修改
//        Book book1 = new Book();
//        book1.setBookId("1");
//        book1.setBookName("javagroup");
//        book1.setbStatus("0");
//        bookService.updateBook(book1);

        // 删除
//        bookService.deleteBook("2");

        // 查询
//        System.out.println(bookService.selectBook());
//        System.out.println(bookService.selectOne("1"));
//        System.out.println(bookService.selectAll());

        // 批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"3", "java", "1"};
//        Object[] o2 = {"4", "python", "1"};
//        Object[] o3 = {"5", "php", "0"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);

        // 批量修改
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"java123", "11", "3"};
//        Object[] o2 = {"python312", "11", "4"};
//        Object[] o3 = {"php12312", "01", "5"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchUpdate(batchArgs);

        // 批量删除
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        bookService.batchDelect(batchArgs);

//        System.out.println((172+126+133+ 8+14));
//        System.out.println((238+228+310+ 3+ 6)/60);
//        user.add();
    }

}
