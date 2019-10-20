package com.cuny.idea.repository;

import com.cuny.idea.bean.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UpvoteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer doesUpvoteExist(int cunyId, int id) {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM upvotes WHERE cuny_id=? and id=?", new Object[] {cunyId, id}, Integer.class);
    }

    public void updateUpvotes(int cunyId, int id) {
        jdbcTemplate.update("INSERT INTO upvotes VALUES(" + cunyId + ", " + id + ")");
    }

    public void delete(int cunyId, int id) {
        jdbcTemplate.update("DELETE FROM upvotes where id=" + id + " and cuny_id=" + cunyId);
    }
}
