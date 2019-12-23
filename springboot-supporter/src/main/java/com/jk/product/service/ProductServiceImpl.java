package com.jk.product.service;

import com.jk.product.mapper.ProductElschConfig;
import com.jk.product.mapper.ProductMapper;
import com.jk.product.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author
 * @Date 2019/12/13 10:35
 * @Version V1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductElschConfig productElschConfig;

    @Override
    public List<Area> queryArea() {
        return productMapper.queryArea();
    }

    @Override
    public List<Brand> queryBrand() {
        return productMapper.queryBrand();
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public Map<String, Object> queryProduct(Integer page, Integer limit,Product product) {
        Map<String, Object> map = new HashMap<>();
        Integer count = productMapper.queryCount(product);
        Integer start = (page-1)*limit;
        List<Product> list = productMapper.queryProduct(start,limit,product);
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    @Override
    public List<Color> queryDetailed(Integer id) {
        return productMapper.queryDetailed(id);
    }

    @Override
    public void addColor(Color color) {
        productMapper.addColor(color);
    }

    @Override
    public void deleteColor(Integer colorid) {
        productMapper.deleteColor(colorid);
        List<Integer> ids = productMapper.queryByIds(colorid);
        if(ids.size()>0){
            productMapper.deleteSize(ids);
            productMapper.deleteColorSize(colorid);
        }

    }

    @Override
    public List<Size> querySize(Integer id) {

        return productMapper.querySize(id);
    }

    @Override
    public void addSize(Size size) {
        productMapper.addSize(size);
        productMapper.addColorAndSize(size.getSizeId(),size.getColorId());
    }

    @Override
    public void deleteSize(Integer sizeId) {
        productMapper.delSize(sizeId);
        productMapper.delColorSize(sizeId);
    }

    @Override
    public void lowerShelf(Integer id) {
        productMapper.lowerShelf(id);
    }

    @Override
    public Map<String, Object> queryProduct2(Integer page, Integer limit, Product product) {
        Map<String, Object> map = new HashMap<>();
        Integer count = productMapper.queryCount2(product);
        Integer start = (page-1)*limit;
        List<Product> list = productMapper.queryProduct2(start,limit,product);
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    @Override
    public void upperShelf(Integer id) {
        productMapper.upperShelf(id);
    }

    @Override
    public void deleteProduct(Integer id) {
        ProductEs productes=productMapper.queryProductId(id);
        productElschConfig.delete(productes);
        List<Integer> colorIds = productMapper.queryColorIdByProductId(id);
        String coloridss = "";
        for (Integer colorId : colorIds) {
            coloridss += ","+colorId;
        }
       // System.out.println(coloridss.substring(1));
        List<Integer> sizeIds = productMapper.querySizeIdByColorId(coloridss.substring(1));
       // System.out.println(sizeIds.toString());
        productMapper.deleteSize(sizeIds);
        productMapper.delColor(coloridss.substring(1));
        productMapper.delAllColorSize(coloridss.substring(1));
        productMapper.delProduct(id);
    }

    @Override
    public void notAll(String ids) {
        productMapper.notAll(ids);
    }

    @Override
    public void putAll(String ids) {
        productMapper.putAll(ids);
    }

    @Override
    public List<Type> type(Integer id) {
        return productMapper.type(id);
    }
}
