package com.cuny.idea.repository;

import com.cuny.idea.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE cuny_id=?", new Object[] {id}, new BeanPropertyRowMapper<>(User.class));
    }

}
