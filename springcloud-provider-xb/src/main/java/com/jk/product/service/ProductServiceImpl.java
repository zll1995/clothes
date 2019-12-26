package com.jk.product.service;

import com.jk.lcw.model.Order;
import com.jk.product.mapper.ProductMapper;
import com.jk.product.model.Color;
import com.jk.product.model.Product;
import com.jk.product.model.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author
 * @Date 2019/12/20 16:22
 * @Version V1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product queryProductById(Integer productId) {
        Product p = productMapper.queryProductById(productId);
        List<Color> color = productMapper.queryColorById(productId);
        List<Size> size = productMapper.querySizeById(color.get(0).getColorid());
        color.get(0).setShowSize(size);
        p.setShowColor(color);
        return p;
    }

    @Override
    public Color queryColor(Integer id) {
        List<Size> size = productMapper.queryColor(id);
        Color c = new Color();
        c.setShowSize(size);
        c.setColorImg(size.get(0).getSizeImg());
        return c;
    }

    @Override
    public List<Product> queryXiangGuan(Integer id) {
        Integer  brandId = productMapper.queryXiangGuan(id);
        List<Product> product = productMapper.queryProduct(brandId);
        for (Product product1 : product) {
            List<Color> color = productMapper.queryColorById(product1.getProductId());
            for (Color color1 : color) {
                List<Size> size = productMapper.querySizeById(color1.getColorid());
                color.get(0).setShowSize(size);
            }
            product1.setShowColor(color);
        }
        return product;
    }
    @Override
    public List<Order> queryshoucang(Integer id) {
        return productMapper.queryshoucang(id);
    }

    @Override
    public void del(Integer id) {
        productMapper.del(id);
    }
}
