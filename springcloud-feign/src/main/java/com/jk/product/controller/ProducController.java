package com.jk.product.controller;

import com.jk.product.model.Color;
import com.jk.product.model.Product;
import com.jk.product.servivce.ProductServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName ProductController
 * @Description
 * @Author
 * @Date 2019/12/20 16:15
 * @Version V1.0
 **/
@Controller
@RequestMapping("product")
public class ProducController {
    @Autowired
    private ProductServiceEntity productServiceEntity;

    @RequestMapping("queryColorAndSize")
    @ResponseBody
    public Product queryColorAndSize(Integer id){
        Product p = productServiceEntity.queryProductById(id);
        return p;
    }

    @RequestMapping("queryColor")
    @ResponseBody
    public Color queryColor(Integer id){
        return productServiceEntity.queryColor(id);
    }

    @RequestMapping("queryXiangGuan")
    @ResponseBody
    public List<Product> queryXiangGuan(Integer id){
        List<Product> l = productServiceEntity.queryXiangGuan(id);
        for (Product product : l) {
            System.out.println(product.getShowColor().get(0).getShowSize());
        }
        return productServiceEntity.queryXiangGuan(id);
    }

    @RequestMapping("todetails")
    public String queryProductById(Integer productId,Model model){
        Product p = productServiceEntity.queryProductById(productId);
        System.out.println(p.getProductName());
        model.addAttribute("p",p);
        model.addAttribute("id",productId);
        return "wxb/details";
    }
}
