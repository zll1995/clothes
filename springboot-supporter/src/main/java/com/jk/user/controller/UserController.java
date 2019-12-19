package com.jk.user.controller;/**
 * @创建人 原国庆
 * @创建时间 2019/12/13
 * @描述
 */

import com.jk.user.model.User;
import com.jk.user.service.UserService;
import com.jk.user.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName UserController
 *@Deacription TODO
 *@Author 原国庆
 *@Date 2019/12/13 15:48
 *@Version 1.0
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryUser")
    @ResponseBody
    public Map queryUser(Integer page, Integer limit, User user) {

        return userService.queryUser(page, limit, user);
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public void deleteUser(String[] ids) {
        userService.deleteUser(ids);
    }

    @RequestMapping("updateById")
    @ResponseBody
    public User updateById(Integer id, HttpSession session) {
        User model = userService.updateById(id);
        session.setAttribute("model", model);
        return model;
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(User model) {
        userService.updateUser(model);
        return "修改成功";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(User user){
        System.err.println(user);
        System.err.println(user);
        System.err.println(user);
        System.err.println(user);
        System.err.println(user);
        userService.addUser(user);
    }

    /**
     * OSS阿里云上传图片
     * @return
     */
    @RequestMapping("updaloadImg")
    @ResponseBody
    public Map uploadImg(MultipartFile img)throws IOException {
        System.err.println(img);
        System.err.println(123333);
        if (img == null || img.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(img);
        String imgUrl = ossClient.getImgUrl(name);
        //String[] split = imgUrl.split("\\?");
        System.out.println("图片url："+imgUrl);
        Map map = new HashMap();
        map.put("imgUrl",imgUrl);
        return map;
    }

}
