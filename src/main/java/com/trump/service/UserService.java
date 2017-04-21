package com.trump.service;

import com.trump.domain.User;

public interface UserService extends BaseService<User> {

    void add(User user) throws Exception;

    User findUserByName(String name) throws Exception;

    void addUser(User user) throws Exception;
}
