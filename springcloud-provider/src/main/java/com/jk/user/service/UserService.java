package com.jk.user.service;

import com.jk.user.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    
    Map queryUser(Integer page, Integer rows, User user);

    void addUser(User user);

    void deleteUser(Integer userId);

    User queryUserById(Integer userId);

    void updateUser(User user);

    List queryTree();

    User queryUserByName(String userName);

    User queryPhone(String phone);

    User userByName(String username);

    void userAdd(User user);
}
