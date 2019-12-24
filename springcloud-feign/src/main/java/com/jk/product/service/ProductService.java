package com.jk.product.service;

import com.jk.product.servivce.ProductServiceEntity;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ClassName ProductService
 * @Description
 * @Author
 * @Date 2019/12/20 16:15
 * @Version V1.0
 **/
@FeignClient(value = "service-provider")
public interface ProductService extends ProductServiceEntity {
}
