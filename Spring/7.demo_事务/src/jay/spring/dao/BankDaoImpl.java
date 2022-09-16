package jay.spring.dao;

import jay.spring.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BankDaoImpl implements BankDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /** 多钱方法 */
    @Override
    public void addMoney() {
        String sql = "update t_bank set money=money+? where name=?";
        jdbcTemplate.update(sql, 100, "Lucy");

    }

    /** 少钱方法 */
    @Override
    public void reduceMoney() {
        String sql = "update t_bank set money=money-? where name=?";
        jdbcTemplate.update(sql, 100, "Tim");
    }
}
