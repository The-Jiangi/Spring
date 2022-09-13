package jay.spring.dao;

import jay.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /** 添加 */
    @Override
    public void add(Book book) {
        // 创建SQL语句
        String sql = "insert into t_book values(?,?,?)";
        // 焦勇方法实现
        Object[] args = {book.getBookId(), book.getBookName(), book.getbStatus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    /** 修改 */
    @Override
    public void update(Book book) {
        // 创建SQL语句
        String sql = "update t_book set id=?,name=?,status=?";
        // 焦勇方法实现
        Object[] args = {book.getBookId(), book.getBookName(), book.getbStatus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    /** 删除 */
    @Override
    public void delete(String id) {
        // 创建SQL语句
        String sql = "delete from t_book where bookId=?";
        // 焦勇方法实现
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    /** 查询1、返回整形 */
    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    /** 查询2、返回对象 */
    @Override
    public Book selectInfo(String id) {
        String sql = "select * from t_book where bookId = ?";
        Book info = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return info;
    }

    /** 查询3、返回集合 */
    @Override
    public List<Book> selectAll() {
        String sql = "select * from t_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }
}
