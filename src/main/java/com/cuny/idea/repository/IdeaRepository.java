package com.cuny.idea.repository;

import com.cuny.idea.bean.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IdeaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Idea findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ideas WHERE cuny_id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Idea.class));
    }

    public List<Idea> findAll() {
        return jdbcTemplate.query("SELECT * FROM IDEAS", new IdeaRowMapper());
    }
}

class IdeaRowMapper implements RowMapper<Idea> {
    @Override
    public Idea mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Idea idea = new Idea();
        idea.setId(resultSet.getInt("id"));
        idea.setTitle(resultSet.getString("title"));
        idea.setDescription(resultSet.getString("description"));
        idea.setUpvotes(resultSet.getInt("upvotes"));
        return idea;
    }
}
