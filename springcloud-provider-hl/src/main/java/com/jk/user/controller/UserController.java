package com.jk.user.controller;

import com.jk.user.model.User;
import com.jk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "queryUser", method = RequestMethod.POST)
    @ResponseBody
    public Map queryUser(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestBody User user){
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        System.out.println("hl");
        return null;
    }

    @RequestMapping(value="addUser",method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(value="deleteUser",method=RequestMethod.POST)
    @ResponseBody
    public void deleteUser(@RequestParam("userId") Integer userId){
        userService.deleteUser(userId);
    }

    @RequestMapping(value="queryUserById",method=RequestMethod.POST)
    @ResponseBody
    public User queryUserById(@RequestParam("userId") Integer userId){
        return userService.queryUserById(userId);
    }

    @RequestMapping(value="updateUser",method = RequestMethod.POST)
    @ResponseBody
    public void updateUser(@RequestBody User user){
        System.out.println(user);
        userService.updateUser(user);
    }



}
