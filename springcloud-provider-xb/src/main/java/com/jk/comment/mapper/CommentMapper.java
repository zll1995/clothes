package com.jk.comment.mapper;

import com.jk.user.model.User;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    User queryUserByUserId(@Param("userId") Integer userId);
}
