package com.jk.user.mapper;

import com.jk.user.model.Order1;
import com.jk.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */
public interface UserMapper {


    List queryUser();

    void deleteUser(@Param("ids") String[] ids);

    User updateById(@Param("id") Integer id);

    void updateUser(User model);

    void addUser(User user);

    List<Map<String, Object>> queryUserBiao();

    List<Map<String, Object>> queryCakeMoney();

    List<Map<String, Object>> queryColumn();

    User queryUserByUsername(@Param("name") String name);

    List<Order1> EcharsShow();
}
