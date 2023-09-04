package com.oliver.Registrationform.repository;

import com.oliver.Registrationform.model.User;

import java.util.List;
import java.util.Map;

public interface DAO {
    User saveUser(User user);

    User findUser(User user);

    List<User> findAllUsers();
}
