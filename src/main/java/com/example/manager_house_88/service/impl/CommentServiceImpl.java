package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Comment;
import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.enums.CommentEnum;
import com.example.manager_house_88.repository.CommentRepo;
import com.example.manager_house_88.service.CommentService;
import com.example.manager_house_88.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserService userService;


    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepo.findAll(pageable);
    }

    @Override
    public List<Comment> findAll(Sort sort) {
        return commentRepo.findAll();
    }

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

    @Override
    public void changeCommentStatus(String commentId) {
        Comment comment = commentRepo.findOne(commentId);
        comment.setCommentStatus(CommentEnum.NOBLE.getCode());
        commentRepo.save(comment);
    }

    /*按类型查询精选或普通评论*/
    @Override
    public List<Comment> findByCommentStatus(Integer commentStatus) {
        return commentRepo.findByCommentStatus(commentStatus);
    }

    /*保存评论*/
    @Override
    public void save(Comment comment) {
        //todo: 暂时取消用过userid获取用户信息  因为小程序认证未完成
        /*User user = userService.findByOpenid(openid);

        comment.setAscriptionId(user.getId());
        comment.setName(user.getName());
        comment.setHeadImg(user.getHeadImgUrl());*/
        commentRepo.save(comment);
    }

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

    /*查询对某个用户或某个经纪人的所有评论*/
    @Override
    public List<Comment> findByAscriptionId(String ascriptionId) {
        return commentRepo.findByAscriptionId(ascriptionId);
    }

    @Override
    public Comment findOne(String commentId){
        return commentRepo.findOne(commentId);
    }
}
