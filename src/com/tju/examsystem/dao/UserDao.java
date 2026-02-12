package com.tju.examsystem.dao;

import com.tju.examsystem.domain.User;

public interface UserDao {
    public boolean findUser(User user);

    void add(User user);

    void deleteByUsername(String username);

    String getPhoto(String username);
}
