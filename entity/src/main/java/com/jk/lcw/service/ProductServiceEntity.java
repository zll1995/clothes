package com.jk.lcw.service;

import com.jk.lcw.model.Advertising;

import com.jk.lcw.model.Order;
import com.jk.lcw.model.ProductEs;
import com.jk.user.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductServiceEntity {
    @PostMapping("queryProduct")
    List queryProduct();
    @PostMapping("queryadvertising")
    List<Advertising> queryadvertising();
    @RequestMapping(value = "xiu",method = RequestMethod.POST)
    void xiu( @RequestBody User user);

    @PostMapping("queryProductAll")
    List<ProductEs> queryProductAll();

    @PostMapping("addDingdan")
    void addDingdan(@RequestBody Order order);
}

