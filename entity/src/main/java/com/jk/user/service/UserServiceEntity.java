package com.jk.user.service;

import com.jk.user.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface UserServiceEntity {
    @RequestMapping(value = "queryUserByName",method = RequestMethod.POST)
    User queryUserByName(@RequestParam("userName")String userName);

    //手机验证
    @RequestMapping(value = "queryPhone",method = RequestMethod.POST)
    User queryPhone(@RequestParam("phone") String phone);

    //用户名是否存在
    @RequestMapping(value = "userByName",method = RequestMethod.POST)
    User userByName(@RequestParam("username") String username);

    //前台注册
    @RequestMapping(value = "userAdd",method = RequestMethod.POST)
    void userAdd(@RequestBody User user);


}
