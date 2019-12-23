package com.jk.lcw.service;

import com.jk.lcw.mapper.ProductMapper;
import com.jk.lcw.model.Advertising;
import com.jk.lcw.model.Product;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;


    @Override
    public List queryProduct() {

        return productMapper.queryProduct();
    }

    @Override
    public List<Advertising> queryadvertising() {
        return productMapper.queryadvertising();
    }

    @Override
    public void xiu(User user) {
        productMapper.xiu(user);
    }

}
