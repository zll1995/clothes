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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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



    //登录方法
    @RequestMapping("login")
    @ResponseBody
    public String login(User user, HttpServletRequest request){

        //验证账号
        User loginUser = userService.queryUserByUsername(user.getName());
        if(loginUser == null){
            return "1";
        }
        //密码
        if(!loginUser.getPassword().equals(user.getPassword())){
            return "2";
        }
        request.getSession().setAttribute("user", loginUser);
        return "3";
    }

    //图形展示
    @RequestMapping("HighCharts")
    @ResponseBody
    public List<Map<String,Object>> queryOrderBiao(){
        List<Map<String,Object>> mapa =userService.queryUserBiao();
        List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();
        for (Map<String,Object> map1:mapa) {
            Map<String,Object> map3=new HashMap<>();
            map3.put("name",map1.get("time"));
            map3.put("data",map1.get("count"));
            map2.add(map3);
        }
        return mapa;
    }

    //饼状图
    @RequestMapping("queryCake")
    @ResponseBody
    public List<Map<String,Object>> queryCakeMoney(){
        List<Map<String,Object>> map1 =userService.queryCakeMoney();
        List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();
        for (Map<String,Object> map:map1) {
            Map<String,Object> map3=new HashMap<>();
            map3.put("y",map.get("y"));
            if(map.get("老师姓名").toString().equals("cxf")){
                map3.put("name","cxf");
                map3.put("sliced",true);
                map3.put("selected",true);
            }else if(map.get("老师姓名").toString().equals("张三")){
                map3.put("name","张三");
            }else if(map.get("老师姓名").toString().equals("李四")){
                map3.put("name","李四");
            }else if(map.get("老师姓名").toString().equals("陈光")){
                map3.put("name","陈光");
            }else if(map.get("老师姓名").toString().equals("陈晓峰")){
                map3.put("name","陈晓峰");
            }else if(map.get("老师姓名").toString().equals("王五")){
                map3.put("name","王五");
            }else if(map.get("老师姓名").toString().equals("ycx")){
                map3.put("name","ycx");
            }else {
                map3.put("name","阿华1");
            }
            map2.add(map3);
        }
        return map2;

    }

    @RequestMapping("queryColumn")
    @ResponseBody
    public Map<String, Object> queryColumn(){
        List<Map<String,Object>> mapa =userService.queryColumn();
        Map<String,Object> map2 =new HashMap<String,Object>();
        List<Object> data = new ArrayList<>();
        List<Object> time = new ArrayList<>();
        for (Map<String,Object> map1:mapa) {
            data.add(map1.get("count"));
            time.add(map1.get("time"));
        }
        map2.put("time",time);
        map2.put("data",data);
        return map2;
    }


}
