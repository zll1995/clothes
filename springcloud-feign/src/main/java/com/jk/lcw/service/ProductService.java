package com.jk.lcw.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-provider1")
public interface ProductService  extends ProductServiceEntity {

}
