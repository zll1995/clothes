package com.jk.comment.service;

import com.jk.comment.mapper.CommentMapper;
import com.jk.comment.model.Comment;
import com.jk.comment.model.Praise;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CommentServiceImpl
 * @Description
 * @Author
 * @Date 2019/12/18 14:13
 * @Version V1.0
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(Comment comment) {
        mongoTemplate.save(comment);
    }

    @Override
    public List<Comment> queryComment(Integer productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        List<Comment> comments = mongoTemplate.find(query, Comment.class);
        return comments;
    }

    @Override
    public Comment queryCommentByPraise(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        List<Comment> comments = mongoTemplate.find(query, Comment.class);
        return comments.get(0);
    }

    @Override
    public void removeBlock(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Comment.class);
    }

    @Override
    public boolean queryPraise(String id, int i) {
        Query query = new Query();
        query.addCriteria(Criteria.where("commentId").is(id).and("userId").is(i));
        boolean b = mongoTemplate.exists(query,Praise.class);
        return b;
    }

    @Override
    public void removePraise(String id, int i) {
        Query query = new Query();
        query.addCriteria(Criteria.where("commentId").is(id).and("userId").is(i));
        mongoTemplate.remove(query,Praise.class);
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("id").is(id));
        List<Comment> comments = mongoTemplate.find(query2, Comment.class);
        Comment c = comments.get(0);
        Update update = new Update();
        update.set("praise",c.getPraise()-1);
        mongoTemplate.updateFirst(query2,update,Comment.class);
    }

    @Override
    public void addPraise(String id, int i) {
        Praise pp = new Praise();
        pp.setCommentId(id);
        pp.setUserId(i);
        mongoTemplate.save(pp);
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("id").is(id));
        List<Comment> comments = mongoTemplate.find(query2, Comment.class);
        Comment c = comments.get(0);
        Update update = new Update();
        update.set("praise",c.getPraise()+1);
        mongoTemplate.updateFirst(query2,update,Comment.class);
    }

    @Override
    public User queryUserByUserId(Integer userId) {
        return commentMapper.queryUserByUserId(userId);
    }
}
