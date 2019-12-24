package com.jk.product.mapper;

import com.jk.product.model.Color;
import com.jk.product.model.Product;
import com.jk.product.model.Size;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ProductMapper
 * @Description
 * @Author
 * @Date 2019/12/20 16:22
 * @Version V1.0
 **/
public interface ProductMapper {
    Product queryProductById(@Param("productId") Integer productId);

    List<Color> queryColorById(@Param("productId") Integer productId);

    List<Size> querySizeById(@Param("colorid")Integer colorid);

    List<Size> queryColor(@Param("id")Integer id);

    Integer queryXiangGuan(@Param("id") Integer id);

    List<Product> queryProduct(@Param("brandId")Integer brandId);
}
