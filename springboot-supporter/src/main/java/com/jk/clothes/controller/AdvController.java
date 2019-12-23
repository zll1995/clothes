package com.jk.clothes.controller;

import com.github.pagehelper.PageInfo;
import com.jk.clothes.model.Advertising;
import com.jk.clothes.model.Area;
import com.jk.clothes.service.AreaService;
import com.jk.clothes.util.LayuiUtil;
import com.jk.clothes.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("adv")
public class AdvController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("queryadv")
    @ResponseBody
    public LayuiUtil queryadv(Integer page, Integer limit){
        PageInfo<Advertising> info  = areaService.queryadv(page,limit);
        LayuiUtil layuiUtil = new LayuiUtil();

        layuiUtil.setCount(info.getTotal());

        layuiUtil.setData(info.getList());

        return layuiUtil ;
    }

    @RequestMapping("deladv")
    @ResponseBody
    public void deladv(String [] ids){
        areaService.deladv(ids);
    }


    @RequestMapping("updaxiajia")
    @ResponseBody
    public void updaxiajia(Integer id){
        areaService.updaxiajia(id);
    }

    @RequestMapping("updashangjia")
    @ResponseBody
    public void updashangjia(Integer id){
        areaService.updashangjia(id);
    }

    @RequestMapping("queryadvId")
    @ResponseBody
    public Advertising queryadvId(Integer id){
        Advertising advertising=  areaService.queryadvId(id);
        return advertising;
    }

    @RequestMapping("addadv")
    @ResponseBody
    public void addadv(Advertising advertising){
        areaService.addadv(advertising);
    }

    //上传图片
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
