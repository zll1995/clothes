package com.jk.lcw.controller;

import com.jk.lcw.model.Advertising;
import com.jk.lcw.model.Order;
import com.jk.lcw.model.Product;
import com.jk.lcw.service.ProductService;
import com.jk.lcw.service.ProductServiceEntity;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping("queryProduct")
    @ResponseBody
    public List queryProduct(){
        List list = productService.queryProduct();
        return list;
    }
    @RequestMapping("queryadvertising")
    @ResponseBody
    public List<Advertising> queryadvertising(){
        List<Advertising> list = productService.queryadvertising();
        return list;
    }

    @RequestMapping(value="xiu",method = RequestMethod.POST)
    @ResponseBody
    public void updateUser(@RequestBody User user){
        productService.xiu(user);
    }

    @PostMapping("queryProductAll")
    @ResponseBody
    public List queryProEs(){
        return productService.queryProEs();
    }

    @PostMapping("addDingdan")
    @ResponseBody
    public void addDingdan(@RequestBody Order order){
        productService.addDingdan(order);
    }


}
