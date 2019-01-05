package com.journey.jdbc;

import com.journey.test.User;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author liuqingwen
 * @date 2018/3/28.
 */
public class JdbcTest {

    @Test
    public void test() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        User user = jdbcTemplate.queryForObject("", User.class);
        List<User> users = jdbcTemplate.queryForList("", User.class);

    }

}
