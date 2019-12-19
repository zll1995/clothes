package com.jk.user.service;

import com.jk.user.model.User;
import com.jk.user.model.WebUser;

import java.util.Map;

/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */
public interface UserService {
    /** @Author 原国庆
     * @Description: 查询管理用户
     * @Param: [page, limit, webUser]
     * @Return: java.util.Map
     * @Create: 2019/12/13 16:06
     */
    Map queryUser(Integer page, Integer limit, User user);

    void deleteUser(String[] ids);

    User updateById(Integer id);

    void updateUser(User model);

    void addUser(User user);

}
