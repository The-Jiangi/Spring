package jay.spring.service;

import jay.spring.dao.BookDao;
import jay.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public void updateBook(Book book) {
        bookDao.update(book);
    }

    public void deleteBook(String id) {
        bookDao.delete(id);
    }

    public int selectBook() {
        return bookDao.selectCount();
    }

    public Book selectOne(String id) {
        return bookDao.selectInfo(id);
    }

    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

}
