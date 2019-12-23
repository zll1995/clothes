package com.jk.user.service;

import com.jk.user.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface UserServiceEntity {
    @RequestMapping(value = "queryUserByName",method = RequestMethod.POST)
    User queryUserByName(@RequestParam("userName")String userName);
}
