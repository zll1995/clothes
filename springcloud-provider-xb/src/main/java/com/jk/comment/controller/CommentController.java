package com.jk.comment.controller;

import com.jk.comment.model.Comment;
import com.jk.comment.model.Praise;
import com.jk.comment.service.CommentService;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CommentController
 * @Description
 * @Author
 * @Date 2019/12/18 14:12
 * @Version V1.0
 **/
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("addComment")
    @ResponseBody
    public void addComment(@RequestBody Comment comment){
        System.out.println(comment.getCommentContent());
        System.out.println(comment.getCommentDate());
        System.out.println(comment.getProductId());
        System.out.println(comment.getUserId());
        commentService.addComment(comment);
    }
    @GetMapping("queryComment")
    @ResponseBody
    public List<Comment> queryComment(@RequestParam("id") Integer productId){
        System.out.println(productId);
        return commentService.queryComment(productId);
    }
    @GetMapping("queryCommentByPraise")
    @ResponseBody
    public Comment queryCommentByPraise(@RequestParam("id") String id){
        return commentService.queryCommentByPraise(id);
    }
    @DeleteMapping("removeBlock")
    @ResponseBody
    public void removeBlock(@RequestParam("id")String id){
        commentService.removeBlock(id);
    }
    @GetMapping("queryPraise")
    @ResponseBody
    public boolean queryPraise(@RequestParam("id")String id, @RequestParam("i")int i){
        return commentService.queryPraise(id,i);
    }
    @DeleteMapping("removePraise")
    @ResponseBody
    public void removePraise(@RequestParam("id")String id, @RequestParam("i")int i){
        commentService.removePraise(id,i);
    }
    @PostMapping("addPraise")
    @ResponseBody
    public void addPraise(@RequestParam("id")String id, @RequestParam("i")int i){
        commentService.addPraise(id,i);
    }

    @RequestMapping(value = "queryUserByUserId",method = RequestMethod.GET)
    @ResponseBody
    public User queryUserByUserId(@RequestParam("userId") Integer userId){
        return commentService.queryUserByUserId(userId);
    }
}
