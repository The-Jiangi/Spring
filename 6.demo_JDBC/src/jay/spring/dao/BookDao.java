package jay.spring.dao;

import jay.spring.entity.Book;

import java.util.List;


public interface BookDao {

    /** 添加方法 */
    void add(Book book);

    void update(Book book);

    void delete(String id);

    int selectCount();

    Book selectInfo(String id);

    List<Book> selectAll();
}
