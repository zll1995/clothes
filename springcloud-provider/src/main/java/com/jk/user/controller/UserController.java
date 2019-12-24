package com.jk.user.controller;

import com.jk.user.model.User;
import com.jk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 登录
    * */
    @RequestMapping(value = "queryUserByName", method = RequestMethod.POST)
    @ResponseBody
    public User queryUserByName( @RequestParam String userName){

        return userService.queryUserByName(userName);
    }


    @RequestMapping(value = "queryUser", method = RequestMethod.POST)
    @ResponseBody
    public Map queryUser(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestBody User user){
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

    /*
     * 查询手机号是否存在
     * */
    @RequestMapping(value ="queryPhone", method = RequestMethod.POST)
    @ResponseBody
    public User queryPhone(String phone) {

        return userService.queryPhone(phone);
    }

    //用户名是否存在
    @RequestMapping(value ="userByName", method = RequestMethod.POST)
    @ResponseBody
    public User userByName(String username) {
        return userService.userByName(username);
    }

    //验证验证码
    @RequestMapping(value ="login2", method = RequestMethod.POST)
    public String login2(String phone, HttpServletRequest request){
        User regUser = userService.queryPhone(phone);
        request.getSession().setAttribute("loginUser", regUser);
        return "index";
    }

    //前台注册
    @RequestMapping(value = "userAdd" ,method = RequestMethod.POST)
    @ResponseBody
    public void userAdd(@RequestBody User user){
        System.err.println(user);
        System.err.println(user);
        System.err.println(user);
        System.err.println(user);
        userService.userAdd(user);
    }


}
