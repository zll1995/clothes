package com.jk.user.service;/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jk.user.mapper.UserMapper;
import com.jk.user.model.Order1;
import com.jk.user.model.User;
import com.jk.user.model.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@ClassName UserServiceImpl
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/13 16:07
 *@Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map queryUser(Integer page, Integer limit, User user) {
        Page<WebUser> objects = PageHelper.startPage(page, limit);
        List list=userMapper.queryUser();
        Map map = new HashMap();
        map.put("count",objects.getTotal());
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @Override
    public void deleteUser(String[] ids) {

        userMapper.deleteUser(ids);

    }

    @Override
    public User updateById(Integer id) {

        return userMapper.updateById(id);

    }

    @Override
    public void updateUser(User model) {

        userMapper.updateUser(model);

    }

    @Override
    public void addUser(User user) {

        userMapper.addUser(user);
    }

    @Override
    public User queryUserByUsername(String name) {
        return userMapper.queryUserByUsername(name);
    }

    @Override
    public List<Map<String, Object>> queryUserBiao() {
        return userMapper.queryUserBiao();
    }

    @Override
    public List<Map<String, Object>> queryCakeMoney() {
        return userMapper.queryCakeMoney();
    }

    @Override
    public List<Map<String, Object>> queryColumn() {
        return userMapper.queryColumn();
    }

    @Override
    public List<Order1> EcharsShow() {
        return userMapper.EcharsShow();
    }


}
