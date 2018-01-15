package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Comment;

import java.security.Principal;
import java.util.List;

public interface CommentService {

    /*根据审核状态查询*/
    List<Comment> findByAuditStatus(Integer status);

    /*根据评论所属类型查询*/
    List<Comment> findByType(Integer type);

    /*按类型查询精选或普通评论*/
    List<Comment> findByCommentStatus(Integer commentStatus);

    /*保存评论*//*
    void save(Comment comment);*/

    /*修改审核状态*/
    void changeAuditStatus(String commentId);

    /*点赞*/
    void raiseLiked(String commentId);

    /*设置评论为精选*/
    void changeCommentStatus(String commentId);

    /*删除评论*/
    void delete(String commentId);

}
