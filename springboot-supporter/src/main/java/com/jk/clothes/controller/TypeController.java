package com.jk.clothes.controller;

import com.github.pagehelper.PageInfo;
import com.jk.clothes.model.Area;
import com.jk.clothes.model.Type;
import com.jk.clothes.service.AreaService;
import com.jk.clothes.util.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("type")
public class TypeController {
    @Autowired
    private AreaService areaService;

    //类型表查询
    @RequestMapping("queryType")
    @ResponseBody
    public LayuiUtil queryType(Integer page, Integer limit){
        PageInfo<Type> info  = areaService.queryType(page,limit);
        LayuiUtil layuiUtil = new LayuiUtil();

        layuiUtil.setCount(info.getTotal());

        layuiUtil.setData(info.getList());

        return layuiUtil ;
    }

    //类型表新增
    @RequestMapping("addtype")
    @ResponseBody
    public void addtype(Type type){
        areaService.addtype(type);
    }

    //类型表批删
    @RequestMapping("deltype")
    @ResponseBody
    public void deltype(String [] ids){
        areaService.deltype(ids);
    }

    //根据ID查询
    @RequestMapping("querytypeId")
    @ResponseBody
    public Type querytypeId(Integer id){
        Type type= areaService.querytypeId(id);
        return type;
    }

}
