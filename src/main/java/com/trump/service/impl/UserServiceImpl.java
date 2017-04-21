package com.trump.service.impl;

import com.trump.dao.UserDao;
import com.trump.domain.User;
import com.trump.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao mUserDao;

    public void add(User user) throws Exception {
    }

    public void del(User user) throws Exception {

    }

    public void update(User user) throws Exception {

    }

    public User findOneById(String id) throws Exception {
        return mUserDao.findOneById(id);
    }

    public User findUserByName(String name) throws Exception {
        return mUserDao.findUserByName(name);
    }

    public void addUser(User user) throws Exception {
        mUserDao.addUser(user);
    }

    public List<User> findAll() throws Exception {
        return null;
    }
}
