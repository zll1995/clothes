package com.jk.clothes.mapper;

import com.jk.clothes.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    
    //地区表
    List<Area> queryArea();

    void addarea(Area area);

    void delarea(@Param("ids") String[] ids);

    Area queryById(Integer id);

    void updatearea(Area area);

    //品牌表
    List<Brand> querybrand();

    void addbrand(Brand brand);

    void updatebrand(Brand brand);

    void delbrand(@Param("ids") String[] ids);

    Brand querybrandId(Integer id);


    //类型表
    List<Type> queryType();

    void deltype(@Param("ids") String[] ids);

    List<Brand> querybrandname();

    void addtype(Type type);

    Type querytypeId(Integer id);

    void updatetype(Type type);


    //广告表-----------------------------------------
    List<Advertising> queryadv();

    void deladv(@Param("ids") String[] ids);

    void updaxiajia(Integer id);

    void updashangjia(Integer id);

    Advertising queryadvId(Integer id);

    void addadv(Advertising advertising);

    void updateadv(Advertising advertising);


    //订单表------------------------------------
    List<Order> queryorder();

    void delorder(@Param("ids") String[] ids);

    List<Order> queryorders();

    void addorder(Order order);
}
