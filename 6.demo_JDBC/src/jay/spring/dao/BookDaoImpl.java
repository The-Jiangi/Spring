package jay.spring.dao;

import jay.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        // 创建SQL语句
        String sql = "insert into t_book values(?,?,?)";
        // 焦勇方法实现
        Object[] args = {book.getBookId(), book.getBookName(), book.getbStatus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }
}
