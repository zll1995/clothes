package com.jk.comment.service;

import com.jk.comment.model.Comment;
import com.jk.comment.model.Praise;
import com.jk.user.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CommentService
 * @Description
 * @Author
 * @Date 2019/12/18 13:51
 * @Version V1.0
 **/
public interface CommentServiceEntity {
    @PostMapping("addComment")
    void addComment(@RequestBody Comment comment);
    @GetMapping("queryComment")
    List<Comment> queryComment(@RequestParam("id") Integer productId);
    @GetMapping("queryCommentByPraise")
    Comment queryCommentByPraise(@RequestParam("id") String id);
    @DeleteMapping("removeBlock")
    void removeBlock(@RequestParam("id") String id);
    @GetMapping("queryPraise")
    boolean queryPraise(@RequestParam("id") String id, @RequestParam("i") int i);
    @DeleteMapping("removePraise")
    void removePraise(@RequestParam("id") String id, @RequestParam("i") int i);
    @PostMapping("addPraise")
    void addPraise(@RequestParam("id") String id, @RequestParam("i") int i);

    @GetMapping("queryUserByUserId")
    User queryUserByUserId(@RequestParam("userId") Integer userId);
}
