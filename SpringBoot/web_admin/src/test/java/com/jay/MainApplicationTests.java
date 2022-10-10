package com.jay;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
public class MainApplicationTests{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads(){
        log.info("记录jdbcTemplate：{}",jdbcTemplate);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_bank", Long.class);
        log.info("记录总数：{}",aLong);
    }
}
