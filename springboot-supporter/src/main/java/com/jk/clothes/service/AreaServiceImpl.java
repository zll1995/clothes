package com.jk.clothes.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.clothes.mapper.AreaMapper;
import com.jk.clothes.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    //地区表---------------------------------------------------
    @Override
    public PageInfo<Area> queryArea(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);

        List<Area> list  = areaMapper.queryArea();

        PageInfo<Area> info = new PageInfo<Area>(list);

        return info;
    }

    @Override
    public void addarea(Area area) {
        if(area.getId()==null){
            areaMapper.addarea(area);
        }else{
            areaMapper.updatearea(area);
        }

    }

    @Override
    public void delarea(String[] ids) {
        areaMapper.delarea(ids);
    }

    @Override
    public Area queryById(Integer id) {
      return   areaMapper.queryById(id);
    }

    //品牌表---------------------------------------------------
    @Override
    public PageInfo<Brand> querybrand(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);

        List<Brand> list  = areaMapper.querybrand();

        PageInfo<Brand> info = new PageInfo<Brand>(list);

        return info;
    }

    @Override
    public void addbrand(Brand brand) {
        if(brand.getBrandId()==null){
            areaMapper.addbrand(brand);
        }else{
            areaMapper.updatebrand(brand);
        }
    }

    @Override
    public void delbrand(String[] ids) {
        areaMapper.delbrand(ids);
    }

    @Override
    public Brand querybrandId(Integer id) {
        return   areaMapper.querybrandId(id);
    }


    //类型表----------------------------------------------
    @Override
    public PageInfo<Type> queryType(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);

        List<Type> list  = areaMapper.queryType();

        PageInfo<Type> info = new PageInfo<Type>(list);

        return info;
    }

    @Override
    public void addtype(Type type) {
        if(type.getTypeId()==null){
            areaMapper.addtype(type);
        }else{
            areaMapper.updatetype(type);
        }

    }

    @Override
    public void deltype(String[] ids) {
        areaMapper.deltype(ids);
    }

    @Override
    public List<Brand> querybrandname() {
        return areaMapper.querybrandname();
    }

    @Override
    public Type querytypeId(Integer id) {
        return areaMapper.querytypeId(id);
    }



    //广告表-------------------------------------------
    @Override
    public PageInfo<Advertising> queryadv(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);

        List<Advertising> list  = areaMapper.queryadv();

        PageInfo<Advertising> info = new PageInfo<Advertising>(list);

        return info;
    }

    @Override
    public void deladv(String[] ids) {
        areaMapper.deladv(ids);
    }

    @Override
    public void updaxiajia(Integer id) {
        areaMapper.updaxiajia(id);
    }

    @Override
    public void updashangjia(Integer id) {
        areaMapper.updashangjia(id);
    }

    @Override
    public Advertising queryadvId(Integer id) {
        return areaMapper.queryadvId(id);
    }

    @Override
    public void addadv(Advertising advertising) {
        if(advertising.getId()==null){
            areaMapper.addadv(advertising);
        }else{
            areaMapper.updateadv(advertising);
        }

    }

    @Override
    public PageInfo<Order> queryorder(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);

        List<Order> list  = areaMapper.queryorder();

        PageInfo<Order> info = new PageInfo<Order>(list);

        return info;
    }

    @Override
    public void delorder(String[] ids) {
        areaMapper.delorder(ids);
    }

    @Override
    public List<Order> queryorders() {
        return areaMapper.queryorders();
    }

    @Override
    public void addorder(Order order) {
        areaMapper.addorder(order);
    }
}
