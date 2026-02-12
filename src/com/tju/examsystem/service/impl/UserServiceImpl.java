package com.tju.examsystem.service.impl;

import com.tju.examsystem.dao.UserDao;
import com.tju.examsystem.dao.impl.UserDaoImpl;
import com.tju.examsystem.domain.User;
import com.tju.examsystem.service.UserService;


public class UserServiceImpl implements UserService {
    UserDao dao=new UserDaoImpl();
    @Override
    public boolean login(User user) {

        return dao.findUser(user);

    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void delete(String username) {
        dao.deleteByUsername(username);
    }

    @Override
    public String getPhoto(String username) {
        return dao.getPhoto(username);
    }
}
