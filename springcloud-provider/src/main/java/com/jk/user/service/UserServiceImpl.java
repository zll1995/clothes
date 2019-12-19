package com.jk.user.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jk.user.mapper.UserMapper;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map queryUser(Integer page, Integer rows, User user) {
        Page<User> objects = PageHelper.startPage(page, rows);
        List<User> users = userMapper.queryUser(user);
        Map<Object, Object> map = new HashMap<>();
        map.put("total",objects.getTotal());
        map.put("rows",users);
        return map;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public User queryUserById(Integer userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List queryTree() {
        return userMapper.queryTree();
    }

    @Override
    public User queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }
}
