package com.jk.product.service;

import com.jk.product.model.Color;
import com.jk.product.model.Product;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description
 * @Author
 * @Date 2019/12/20 16:22
 * @Version V1.0
 **/
public interface ProductService {
    Product queryProductById(Integer productId);

    Color queryColor(Integer id);

    List<Product> queryXiangGuan(Integer id);
}
