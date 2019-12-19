package com.jk.user.service;

import com.jk.user.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface UserServiceEntity {
    @RequestMapping(value = "queryUser", method = RequestMethod.POST)
    Map queryUser(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestBody User user);

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    void addUser(@RequestBody User user);

    @RequestMapping(value ="deleteUser",method = RequestMethod.POST)
    void deleteUser(@RequestParam("userId") Integer userId);

    @RequestMapping(value = "queryUserById",method = RequestMethod.POST)
    User queryUserById(@RequestParam("userId") Integer userId);

    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    void updateUser(@RequestBody User user);

    @RequestMapping(value = "queryUserByName",method = RequestMethod.POST)
    User queryUserByName(@RequestParam("userName")String userName);
}
