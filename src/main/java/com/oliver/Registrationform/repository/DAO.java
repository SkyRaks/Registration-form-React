package com.oliver.Registrationform.repository;

import com.oliver.Registrationform.model.User;

public interface DAO {
    int saveUser(User user);

    int findUser(User user);
}
