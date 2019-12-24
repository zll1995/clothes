package com.jk.product.servivce;

import com.jk.product.model.Color;
import com.jk.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName ProductServiceEntity
 * @Description
 * @Author
 * @Date 2019/12/20 16:16
 * @Version V1.0
 **/
public interface ProductServiceEntity {
    @GetMapping("queryProductById")
    Product queryProductById(@RequestParam("productId") Integer productId);
    @GetMapping("queryColor")
    Color queryColor(@RequestParam("id") Integer id);
    @GetMapping("queryXiangGuan")
    List<Product> queryXiangGuan(@RequestParam("id") Integer id);
}
