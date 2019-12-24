package com.jk.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ClassName ToController
 * @Description
 * @Author
 * @Date 2019/12/18 11:03
 * @Version V1.0
 **/
@Controller
@RequestMapping("to")
public class ToController {
    @RequestMapping("toComment")
    public String toComment(){
        return "wxb/comment";
    }
    @RequestMapping("toDetails")
    public String toDetails(Model model){
       // Map<String,Object> queryProduct =
        return "wxb/details";
    }
}
