package com.jk.clothes.service;

import com.github.pagehelper.PageInfo;
import com.jk.clothes.model.*;

import java.util.List;

public interface AreaService {
    //地区表----------------------------------------
    PageInfo<Area> queryArea(Integer page, Integer limit);

    void addarea(Area area);

    void delarea(String[] ids);

    Area queryById(Integer id);


    //品牌 表-------------------------------------
    PageInfo<Brand> querybrand(Integer page, Integer limit);

    void addbrand(Brand brand);

    void delbrand(String[] ids);

    Brand querybrandId(Integer id);


    //类型表-----------------------------------
    PageInfo<Type> queryType(Integer page, Integer limit);

    void addtype(Type type);

    void deltype(String[] ids);

    List<Brand> querybrandname();

    Type querytypeId(Integer id);



    //广告 表-----------------------------------------
    PageInfo<Advertising> queryadv(Integer page, Integer limit);

    void deladv(String[] ids);

    void updaxiajia(Integer id);

    void updashangjia(Integer id);

    Advertising queryadvId(Integer id);

    void addadv(Advertising advertising);

    //订单表----------------------------------
    PageInfo<Order> queryorder(Integer page, Integer limit);

    void delorder(String[] ids);

    List<Order> queryorders();

    void addorder(Order order);
}
