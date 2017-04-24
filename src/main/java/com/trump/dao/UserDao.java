package com.trump.dao;

import com.trump.domain.User;

public interface UserDao extends BaseDao<User> {

    User findUserByName(String name) throws Exception;
}