package com.jk.comment.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ClassName CommentService
 * @Description
 * @Author
 * @Date 2019/12/18 13:47
 * @Version V1.0
 **/
@FeignClient(value = "service-provider")
public interface CommentService extends CommentServiceEntity {

}
