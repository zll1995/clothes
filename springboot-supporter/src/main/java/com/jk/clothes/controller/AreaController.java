package com.jk.clothes.controller;

import com.github.pagehelper.PageInfo;
import com.jk.clothes.model.Area;
import com.jk.clothes.service.AreaService;
import com.jk.clothes.util.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    //地区表查询
    @RequestMapping("queryArea")
    @ResponseBody
    public LayuiUtil queryCar(Integer page, Integer limit){
        PageInfo<Area> info  = areaService.queryArea(page,limit);
        LayuiUtil layuiUtil = new LayuiUtil();

        layuiUtil.setCount(info.getTotal());

        layuiUtil.setData(info.getList());

        return layuiUtil ;
    }

    //地区表新增
    @RequestMapping("addarea")
    @ResponseBody
    public void addarea(Area area){
        areaService.addarea(area);
    }

    //地区表批删
    @RequestMapping("delarea")
    @ResponseBody
    public void delarea(String [] ids){
        areaService.delarea(ids);
    }

    //根据ID查询
    @RequestMapping("queryById")
    @ResponseBody
    public Area queryById(Integer id){
        Area a= areaService.queryById(id);
        return a;
    }



}
