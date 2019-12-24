package com.jk.lcw.repository;

import com.jk.lcw.model.ProductEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @创建人 原国庆
 * @创建时间 2019/12/20
 * @描述
 */
public interface ProductResopitory extends ElasticsearchCrudRepository<ProductEs,Integer> {
}
