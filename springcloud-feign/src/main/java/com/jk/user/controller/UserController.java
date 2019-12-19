package com.jk.user.controller;

import com.jk.user.model.User;
import com.jk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 登录
    * */
    @RequestMapping("queryUserByName")
    @ResponseBody
    public Integer queryUserByName(User user, HttpServletRequest request){
        try {
            User u=userService.queryUserByName(user.getUsername());
             if(u==null){
                 return 1;
             }
             if(u!=null && u.getPassword().equals(user.getPassword())){
                 //将登录对象存入session
                 request.getSession().setAttribute(request.getSession().getId(), u);
                 return 2;
             }if(u!=null && !u.getPassword().equals(user.getPassword())){
                 return 3;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
    @RequestMapping("queryUser")
    @ResponseBody
    public Map queryUser(Integer page, Integer limit, User user){
        return  userService.queryUser(page,limit,user);
    }

    @RequestMapping("addUser")
    @ResponseBody
    public  void addUser(User user){
        userService.addUser(user);
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public void deleteUser(Integer userId){
        userService.deleteUser(userId);
    }

    @RequestMapping("queryUserById")
    @ResponseBody
    public  User queryUserById(Integer userId){
        return userService.queryUserById(userId);
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public void updateUser(User user){
        userService.updateUser(user);
    }
    @RequestMapping("showUser")
    public String showUser(){
        return "user/showUser";
    }

    @RequestMapping("query")
    public String query(){
        return "lcw/index";
    }


    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("toMain")
    public String main(){
        return "main";
    }
	
	


}
