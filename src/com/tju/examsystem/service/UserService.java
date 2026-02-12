package com.tju.examsystem.service;

import com.tju.examsystem.domain.User;

public interface UserService {
    public boolean login(User user);

    void add(User user);

    void delete(String username);

    String getPhoto(String username);
}
