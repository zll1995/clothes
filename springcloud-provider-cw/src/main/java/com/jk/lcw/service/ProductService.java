package com.jk.lcw.service;

import com.jk.lcw.model.Advertising;
import com.jk.user.model.User;

import java.util.List;
import java.util.Map;

public interface ProductService {


    List queryProduct();

    List<Advertising> queryadvertising();

    void xiu(User user);
}
