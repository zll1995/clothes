package com.jk.product.service;

import com.jk.product.model.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductService
 * @Description
 * @Author
 * @Date 2019/12/13 10:35
 * @Version V1.0
 **/
public interface ProductService {
    List<Area> queryArea();

    List<Brand> queryBrand();

    void addProduct(Product product);

    Map<String, Object> queryProduct(Integer page, Integer limit,Product product);

    List<Color> queryDetailed(Integer id);

    void addColor(Color color);

    void deleteColor(Integer colorid);

    List<Size> querySize(Integer id);

    void addSize(Size size);

    void deleteSize(Integer sizeId);

    void lowerShelf(Integer id);

    Map<String, Object> queryProduct2(Integer page, Integer limit, Product product);

    void upperShelf(Integer id);

    void deleteProduct(Integer id);

    void notAll(String ids);

    void putAll(String ids);

    List<Type> type(Integer id);
}
