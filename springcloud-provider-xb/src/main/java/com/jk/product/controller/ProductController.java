package com.jk.product.controller;

import com.jk.product.model.Color;
import com.jk.product.model.Product;
import com.jk.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @ClassName ProductController
 * @Description
 * @Author
 * @Date 2019/12/20 16:22
 * @Version V1.0
 **/
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("queryProductById")
    @ResponseBody
    public Product queryProductById(@RequestParam("productId") Integer productId){
        System.out.println(productId);
        return productService.queryProductById(productId);
    }
    @GetMapping("queryColor")
    @ResponseBody
    public Color queryColor(@RequestParam("id") Integer id){
        return productService.queryColor(id);
    }
    @GetMapping("queryXiangGuan")
    @ResponseBody
    public List<Product> queryXiangGuan(@RequestParam("id") Integer id){
        return productService.queryXiangGuan(id);
    }
}
