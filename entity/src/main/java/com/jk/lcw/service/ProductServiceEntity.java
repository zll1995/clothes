package com.jk.lcw.service;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ProductServiceEntity {
    @PostMapping("queryProduct")
    List queryProduct();

}

