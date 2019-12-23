package com.jk.clothes.controller;

import com.github.pagehelper.PageInfo;
import com.jk.clothes.model.Area;
import com.jk.clothes.model.Brand;
import com.jk.clothes.service.AreaService;
import com.jk.clothes.util.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("brand")
public class BrandController {

    @Autowired
   private AreaService areaService;

    //品牌表查询
    @RequestMapping("querybrand")
    @ResponseBody
    public LayuiUtil querybrand(Integer page, Integer limit){

        PageInfo<Brand> info  = areaService.querybrand(page,limit);
        LayuiUtil layuiUtil = new LayuiUtil();

        layuiUtil.setCount(info.getTotal());

        layuiUtil.setData(info.getList());

        return layuiUtil ;
    }

    //品牌表新增
    @RequestMapping("addbrand")
    @ResponseBody
    public void addbrand(Brand brand){
        areaService.addbrand(brand);
    }

    //品牌表批删
    @RequestMapping("delbrand")
    @ResponseBody
    public void delbrand(String [] ids){
        areaService.delbrand(ids);
    }

    //根据ID查询
    @RequestMapping("querybrandId")
    @ResponseBody
    public Brand querybrandId(Integer id){
        Brand b= areaService.querybrandId(id);
        return b;
    }

    @RequestMapping("querybrandname")
    @ResponseBody
    public List<Brand> querybrandname(){
        List<Brand> list= areaService.querybrandname();
        return list;
    }
}
