package com.oliver.Registrationform.repository;

import com.oliver.Registrationform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements DAO{
    private static final String ADD_NEW_USER_SQL = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ? AND password = ?";
    private static final String FIND_ALL_USERS = "SELECT * FROM users;";

    private JdbcTemplate jdbcTemplate;
    private UserRowMapper userRowMapper;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    @Override
    public User saveUser(User user) {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
        jdbcTemplate.update(ADD_NEW_USER_SQL, username, email, password);
        return user;
    }

    @Override
    public User findUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        try {
            return jdbcTemplate.queryForObject(FIND_USER_BY_EMAIL_AND_PASSWORD, userRowMapper, email, password);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> findAllUsers() {
        List<User> allUsers = jdbcTemplate.query(FIND_ALL_USERS, userRowMapper);
        return allUsers;
    }
}
