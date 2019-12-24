package com.jk.comment.service;

import com.jk.comment.model.Comment;
import com.jk.comment.model.Praise;
import com.jk.user.model.User;

import java.util.List;

/**
 * @ClassName CommentService
 * @Description
 * @Author
 * @Date 2019/12/18 14:12
 * @Version V1.0
 **/
public interface CommentService {
    void addComment(Comment comment);

    List<Comment> queryComment(Integer productId);

    Comment queryCommentByPraise(String id);

    void removeBlock(String id);

    boolean queryPraise(String id, int i);

    void removePraise(String id, int i);

    void addPraise(String id, int i);

    User queryUserByUserId(Integer userId);
}
