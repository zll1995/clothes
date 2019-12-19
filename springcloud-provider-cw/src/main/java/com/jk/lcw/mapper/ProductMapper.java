package com.jk.lcw.mapper;

import com.jk.lcw.model.Advertising;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    List queryProduct();

    List<Advertising> queryadvertising();
}
