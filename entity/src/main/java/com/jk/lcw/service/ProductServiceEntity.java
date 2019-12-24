package com.jk.lcw.service;

import com.jk.lcw.model.Advertising;
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
}

