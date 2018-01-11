package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Comment;

import java.security.Principal;
import java.util.List;

public interface CommentService {

    /*根据审核状态查询 */
    List<Comment> findByStatus(Integer status);

    /*根据评论所属类型查询*/
    List<Comment> findByType(Integer type);

    /*保存评论*/
    void save(Comment comment, String openid);

    /*修改审核状态*/
    void changeAuditStatus(String commentId);

    //点赞
    void raiseLiked(String commentId);



}
