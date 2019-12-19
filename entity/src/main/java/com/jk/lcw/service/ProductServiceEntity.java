package com.jk.lcw.service;

import com.jk.lcw.model.Advertising;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ProductServiceEntity {
    @PostMapping("queryProduct")
    List queryProduct();
    @PostMapping("queryadvertising")
    List<Advertising> queryadvertising();

}

