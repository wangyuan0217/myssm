package com.trump.service;

import com.trump.domain.User;

public interface UserService extends BaseService<User> {
    
    User findUserByName(String name) throws Exception;

}
