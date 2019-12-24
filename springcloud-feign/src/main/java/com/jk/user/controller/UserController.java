package com.jk.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.user.model.User;
import com.jk.user.service.UserService;
import com.jk.user.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

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


    //前台注册
    @RequestMapping("userAdd")
    @ResponseBody
    public void  userAdd(User user){
        System.err.println(user);
        userService.userAdd(user);
    }

    //验证用户名是否存在
    @RequestMapping("userByName")
    @ResponseBody
    public String  userByName(User user){
        User userName= userService.userByName(user.getUsername());
        if(userName!=null){
            return "fail";
        }
        return "success";
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


    /*
     * 查询手机号是否存在
     * */
    @RequestMapping("queryPhone")
    @ResponseBody
    public String queryPhone(String phone) {
        User regUser = userService.queryPhone(phone);
        if (regUser != null) {
            return "success";
        }
        return "fail";
    }


    //验证验证码
    @RequestMapping("login2")
    public String login2(String phone, HttpServletRequest request){
        User regUser = userService.queryPhone(phone);
        request.getSession().setAttribute("loginUser", regUser);
        return "lcw/index";
    }

    @RequestMapping("hqyzm")
    @ResponseBody
    public int jsUser(String  phone) {
        //2.发送短信验证码
        String url = "https://api.netease.im/sms/sendcode.action";
        //header的参数
        HashMap<String, Object> header = new HashMap<String, Object>();
        String nonce = UUID.randomUUID().toString();
        String curTime = String.valueOf(System.currentTimeMillis() / 1000);//当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数(String)
        header.put("AppKey", "b9906105b99bfda985ec37dce93f6c6d");//开发者平台分配的appkey
        header.put("Nonce", nonce);//随机数（最大长度128个字符
        header.put("CurTime", curTime);//当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数(String)
        //SHA1(AppSecret + Nonce + CurTime)，三个参数拼接的字符串，进行SHA1哈希计算，转化成16进制字符(String，小写)
        String appSecret = "0ed4979cf256";
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        header.put("CheckSum", checkSum);

        //body的参数
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("mobile", phone);//手机号
        params.put("templateid", 14845712);//模板编号(如不指定则使用配置的默认模版)
        //验证码
        int code = (int)Math.round(Math.random() * 899999 + 100000);
        params.put("authCode", code);//客户自定义验证码，长度为4～10个数字

        String str = HttpClientUtil.post3(url, params, header);
        JSONObject obj = JSON.parseObject(str);
        int recode = obj.getIntValue("code");
        if (recode != 200) {
            return recode;
        }
        return code;
    }



}
