package com.jk.lcw.service;

import com.jk.lcw.model.Advertising;
import com.jk.user.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface ProductServiceEntity {
    @PostMapping("queryProduct")
    List queryProduct();
    @PostMapping("queryadvertising")
    List<Advertising> queryadvertising();
    @PutMapping("xiu")
    void xiu(User user);
}

