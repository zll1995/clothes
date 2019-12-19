package com.jk.user.mapper;

import com.jk.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

}
