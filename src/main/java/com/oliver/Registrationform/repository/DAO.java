package com.oliver.Registrationform.repository;

import com.oliver.Registrationform.model.User;

import java.util.List;
import java.util.Map;

public interface DAO {
    int saveUser(User user);

    int findUser(User user);

    List<User> findAllUsers();
}
