package com.jk.user.mapper;

import com.jk.user.model.User;

import java.util.List;

public interface UserMapper {
    
    List<User> queryUser(User user);

    void addUser(User user);

    void deleteUser(Integer userId);

    User queryUserById(Integer userId);

    void updateUser(User user);

    List queryTree();

    User queryUserByName(String userName);

    User queryPhone(String phone);

    void userAdd(User user);

    User userByName(String username);
}
