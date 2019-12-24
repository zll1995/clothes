package com.jk.comment.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @ClassName Praise
 * @Description
 * @Author
 * @Date 2019/12/19 9:16
 * @Version V1.0
 **/
@Document(value = "t_praise")
public class Praise implements Serializable {
    private static final long serialVersionUID = 6217737238217439566L;

    private String id;

    private String commentId;

    private Integer userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
