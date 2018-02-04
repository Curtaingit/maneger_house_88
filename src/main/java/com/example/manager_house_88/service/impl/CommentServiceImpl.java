package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Comment;
import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.enums.CommentEnum;
import com.example.manager_house_88.enums.CommentPraiseEnum;
import com.example.manager_house_88.enums.ResultExceptionEnum;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.repository.CommentRepo;
import com.example.manager_house_88.service.CommentService;
import com.example.manager_house_88.service.UserService;
import com.example.manager_house_88.utils.RaiseLikedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepo.findAll(pageable);
    }

    @Override
    public Comment findOneByUserId(String userId, String commentId) {
        Comment comment = findOne(commentId);
        if (redisTemplate.hasKey(userId + commentId)) {
            String praise = (String) redisTemplate.opsForValue().get(userId + commentId);
            comment.setPraise(praise);
        }else {
            comment.setPraise(CommentPraiseEnum.DISPRAISE.getMsg());
        }
        String liked = (String) redisTemplate.opsForValue().get(commentId + "liked");
        comment.setLiked(Integer.valueOf(liked));
        return comment;
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
        if (comment == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.COMMENT_NOT_EXIST);
        }
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

        Comment rs = commentRepo.save(comment);
        /*redis 保存点赞数*/
        redisTemplate.opsForValue().set(rs.getId() + "liked", String.valueOf(comment.getLiked()));

    }

    /*评论审核*/
    @Override
    public void changeAuditStatus(String commentId) {
        Comment comment = commentRepo.findOne(commentId);
        if (comment == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.COMMENT_NOT_EXIST);
        }
        if (CommentEnum.WAIT_AUDIT_STATUS.getCode() == comment.getAuditStatus()) {
            comment.setAuditStatus(CommentEnum.AGREE_AUDIT_STATUS.getCode());
        }
        commentRepo.save(comment);
    }

    /*点赞*/
    @Override
    public void raiseLiked(String commentId, String userId) {
        //判断用户是否点赞
        String key = userId + commentId;

        String likedKey = commentId + "liked";

        if (redisTemplate.hasKey(key)) {
            String isPraise = (String) redisTemplate.opsForValue().get(key);
            //1表示用户已经点赞  那么就要取消赞
              if (CommentPraiseEnum.PRAISE.getMsg().equals(isPraise)) {
                //评论的总赞数减1  //将用户改为未点赞状
                RaiseLikedUtil.reduce(key,likedKey);
            } else {
                //评论的总赞数加1 // 将用户改为点赞状态
                RaiseLikedUtil.raise(key,likedKey);
            }
        } else {

            // 创建用户点赞记录
            redisTemplate.opsForValue().set(key, CommentPraiseEnum.PRAISE.getMsg());

            //评论的总赞数加1
            RaiseLikedUtil.raise(key,likedKey);

        }

    }


/*    @Override
    public void raiseLiked(String commentId, String userId) {
        *//*判断用户是否点赞*//*
        String key = userId + commentId;

        if (redisTemplate.hasKey(key)) {
            String isPraise = (String) redisTemplate.opsForValue().get(key);
            *//*1表示用户已经点赞  那么就要取消赞*//*
            if (CommentPraiseEnum.PRAISE.getMsg().equals(isPraise)) {

                *//*评论的总赞数减1*//*
                String liked = (String) redisTemplate.opsForValue().get(commentId + "liked");
                redisTemplate.opsForValue().set(commentId + "liked", String.valueOf(Integer.valueOf(liked) - 1));

                *//*将用户改为未点赞状态*//*
                redisTemplate.opsForValue().set(key, CommentPraiseEnum.DISPRAISE.getMsg());

            } else {
                *//*评论的总赞数加1*//*
                String liked = (String) redisTemplate.opsForValue().get(commentId + "liked");
                redisTemplate.opsForValue().set(commentId + "liked", String.valueOf(Integer.valueOf(liked) + 1));

                *//*将用户改为点赞状态*//*
                redisTemplate.opsForValue().set(key, CommentPraiseEnum.PRAISE.getMsg());
            }
        } else {
            *//*表示用户从未对此评论点过赞*//*

     *//*创建用户点赞记录*//*
            redisTemplate.opsForValue().set(key, CommentPraiseEnum.PRAISE.getMsg());

            *//*评论的总赞数加1*//*
            String liked = (String) redisTemplate.opsForValue().get(commentId + "liked");
            redisTemplate.opsForValue().set(commentId + "liked", String.valueOf(Integer.valueOf(liked) + 1));

        }

    }*/

    /*查询对某个用户或某个经纪人的所有评论*/
    @Override
    public List<Comment> findByAscriptionId(String ascriptionId, String userId) {
        List<Comment> commentList = commentRepo.findByAscriptionId(ascriptionId);
        for (Comment comment : commentList) {

            String key = userId + comment.getId();

            String liked = (String) redisTemplate.opsForValue().get(comment.getId() + "liked");
            comment.setLiked(Integer.valueOf(liked));
            if (redisTemplate.hasKey(key)) {
                String praise = (String) redisTemplate.opsForValue().get(key);
                comment.setPraise(praise);
            } else {
                comment.setPraise(CommentPraiseEnum.DISPRAISE.getMsg());
            }
        }

        return commentList;
    }

    @Override
    public Comment findOne(String commentId) {

        Comment comment = commentRepo.findOne(commentId);
        if (comment == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.COMMENT_NOT_EXIST);
        }
        return comment;
    }


}
