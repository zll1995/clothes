package com.jk.user.service;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-provider3")
public interface UserService extends UserServiceEntity{

}
