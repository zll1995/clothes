package com.jk.user.controller;

import com.jk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TreeController {
    @Autowired
    private UserService userService;

    @RequestMapping("queryTree")
    public List queryTree(){
        return userService.queryTree();
    }

}
