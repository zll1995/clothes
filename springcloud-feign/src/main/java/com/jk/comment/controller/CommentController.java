package com.jk.comment.controller;

import com.jk.comment.model.Comment;
import com.jk.comment.model.Praise;
import com.jk.comment.service.CommentServiceEntity;
import com.jk.user.model.User;
import com.jk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CommentController
 * @Description
 * @Author
 * @Date 2019/12/18 13:36
 * @Version V1.0
 **/
@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentServiceEntity commentServiceEntity;

    @Autowired
    private UserService UserServiceEntity;

    @RequestMapping("addComment")
    @ResponseBody
    public void addComment(Comment comment, HttpServletRequest request){
        comment.setProductId(comment.getProductId());
        User u = (User) request.getSession().getAttribute(request.getSession().getId());
        System.err.println(u.getUserid());
        comment.setUserId(u.getUserid());
        comment.setPraise(1);
        commentServiceEntity.addComment(comment);
    }
    @RequestMapping("queryComment")
    @ResponseBody
    public List<Comment> queryComment(Integer productId){
        List<Comment> comments = commentServiceEntity.queryComment(productId);
        for (Comment comment1 : comments) {
            System.err.println(comment1.getUserId());
            User user = commentServiceEntity.queryUserByUserId(comment1.getUserId());
            Comment cc = commentServiceEntity.queryCommentByPraise(comment1.getId());
            comment1.setUserName(user.getUsername());
            comment1.setUserImg(user.getUserimg());
            comment1.setPraise(cc.getPraise());
        }
        return comments;
    }
    @RequestMapping("removeBlock")
    @ResponseBody
    public boolean removeBlock(String id,Integer userId, HttpServletRequest request){
        System.out.println(userId);
        User u = (User) request.getSession().getAttribute(request.getSession().getId());
        if(userId == u.getUserid()){
            commentServiceEntity.removeBlock(id);
            return true;
        }
        return false;
    }
    @RequestMapping("queryPraise")
    @ResponseBody
    public boolean queryPraise(String id,HttpServletRequest request){
        User u = (User) request.getSession().getAttribute(request.getSession().getId());
       boolean p =  commentServiceEntity.queryPraise(id,u.getUserid());
       if(p){
           commentServiceEntity.removePraise(id,u.getUserid());
           return true;
       }
       commentServiceEntity.addPraise(id,u.getUserid());
       return false;
    }
}
