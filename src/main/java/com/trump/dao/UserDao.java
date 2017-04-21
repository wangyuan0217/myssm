package com.trump.dao;

import com.trump.domain.User;

public interface UserDao extends BaseDao<User> {

    User findOneById(String id) throws Exception;

    User findUserByName(String name) throws Exception;

    void addUser(User user) throws Exception;
}