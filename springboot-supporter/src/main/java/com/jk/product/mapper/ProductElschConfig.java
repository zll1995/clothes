package com.jk.product.mapper;

import com.jk.product.model.ProductEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ProductElschConfig extends ElasticsearchCrudRepository<ProductEs,Integer> {
}
