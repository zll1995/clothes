package com.jk.comment.model;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Comment
 * @Description
 * @Author
 * @Date 2019/12/18 13:37
 * @Version V1.0
 **/
@Document(collection = "t_comments")
public class Comment implements Serializable {

    private static final long serialVersionUID = 6930475274985491737L;
    private String id;  //  此条评论的id
    private Integer productId;   //  评论的商品id
    private Integer userId;  //  评论人Id session
    private String commentContent;  //  评论内容
    private String commentDate; //  评论时间
    private String commentPid;   //  被回复的评论的id 有为评论id无为0
    private Integer praise; //  点赞数
    private String replyName;  //  评论人名字
    @Transient
    private List<Comment> reply;    //  回复的内容
    @Transient
    private String userImg;
    @Transient
    private String userName;

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(String commentPid) {
        this.commentPid = commentPid;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public List<Comment> getReply() {
        return reply;
    }

    public void setReply(List<Comment> reply) {
        this.reply = reply;
    }
}
