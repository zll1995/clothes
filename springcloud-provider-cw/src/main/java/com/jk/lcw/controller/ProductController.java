package com.jk.lcw.controller;

import com.jk.lcw.model.Product;
import com.jk.lcw.service.ProductService;
import com.jk.lcw.service.ProductServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return productService.queryProduct();
    }
}
