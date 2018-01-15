package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Comment;
import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.enums.CommentEnum;
import com.example.manager_house_88.repository.CommentRepo;
import com.example.manager_house_88.service.CommentService;
import com.example.manager_house_88.service.UserService;
import com.example.manager_house_88.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserService userService;


    /*根据评论是否审核 查询*/
    @Override
    public List<Comment> findByAuditStatus(Integer status) {
        return commentRepo.findByAuditStatus(status);
    }

    /*通过commentId删除一条评论*/
    @Override
    public void delete(String commentId) {
        commentRepo.delete(commentId);
    }

    /*根据评论所属类型查询*/
    @Override
    public List<Comment> findByType(Integer type) {
        return commentRepo.findByType(type);
    }

    @Override
    public void changeCommentStatus(String commentId) {
        Comment comment = commentRepo.findOne(commentId);
        comment.setCommentStatus(CommentEnum.NOBLE.getCode());
        commentRepo.save(comment);
    }

    /*按类型查询精选或普通评论*/
    @Override
    public List<Comment> findByCommentStatus(Integer commentStatus) {
        return findByCommentStatus(commentStatus);
    }

  /*  @Override
    public void save(Comment comment) {

    }

    *//*保存评论*//*
    @Override
    public void save(Comment comment, String openid) {
        User user = userService.findByOpenid(openid);
        comment.setNumber(NumberUtil.getNumber());
        comment.setAscriptionId(user.getId());
        comment.setName(user.getName());
        comment.setHeadImg(user.getHeadImgUrl());
        commentRepo.save(comment);
    }*/

    /*评论审核*/
    @Override
    public void changeAuditStatus(String commentId) {
        Comment comment = commentRepo.findOne(commentId);
        if (CommentEnum.WAITAUDITSTATUS.getCode() == comment.getAuditStatus()) {
            comment.setAuditStatus(CommentEnum.AGREEAUDITSTATUS.getCode());
        }
        commentRepo.save(comment);
    }

    /*点赞*/
    @Override
    public void raiseLiked(String commentId) {
        //todo  限定一个用户 一条评论只能点赞一次
    }
}
