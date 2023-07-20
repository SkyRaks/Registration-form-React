package com.oliver.Registrationform.repository;

import com.oliver.Registrationform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements DAO{
    private static final String ADD_NEW_USER_SQL = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
    private static final String FIND_USER_SQL = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveUser(User user) {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
        int updated = jdbcTemplate.update(ADD_NEW_USER_SQL, username, email, password);
        return updated;
    }

    @Override
    public int findUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        Integer rowCount = jdbcTemplate.queryForObject(FIND_USER_SQL, Integer.class, email, password);
        return rowCount;
    }

}
