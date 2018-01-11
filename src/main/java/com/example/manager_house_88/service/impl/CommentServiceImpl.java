package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Agent;
import com.example.manager_house_88.domain.Comment;
import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.enums.CommentEnum;
import com.example.manager_house_88.enums.UserEnum;
import com.example.manager_house_88.repository.CommentRepo;
import com.example.manager_house_88.service.AgentService;
import com.example.manager_house_88.service.CommentService;
import com.example.manager_house_88.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private AgentService agentService;


    /*根据评论是否审核 查询*/
    @Override
    public List<Comment> findByStatus(Integer status) {
        return commentRepo.findByAuditStatus(status);
    }

    @Override
    public List<Comment> findByType(Integer type) {
        return commentRepo.findByType(type);
    }

    /*保存评论*/
    @Override
    public void save(Comment comment, String openid) {
        User user = userService.findByOpenid(openid);

        if(UserEnum.USERASCRIPTION.getCode()==user.getCharacter()){
             /*普通用户评论*/
            comment.setUserId(user.getId());
            comment.setAscription(CommentEnum.USERASCRIPTION.getCode());
            comment.setName(user.getName());
            comment.setHeadImg(user.getHeadImgUrl());
        }else
        {
            /*经纪人用户评论*/
            Agent agent = agentService.findByOpenid(openid);
            comment.setAgentId(agent.getId());
            comment.setAscription(CommentEnum.AGENTASCRIPTION.getCode());
            comment.setName(agent.getName());
            comment.setHeadImg(agent.getHeadImg());
        }
        commentRepo.save(comment);
    }

    /*评论审核*/
    @Override
    public void changeAuditStatus(String commentId) {
        Comment comment = commentRepo.findOne(commentId);
        if (CommentEnum.WAITAUDITSTATUS.getCode()==comment.getStatus()){
            comment.setStatus(CommentEnum.AGREEAUDITSTATUS.getCode());
        }
        commentRepo.save(comment);
    }

    /*点赞*/
    @Override
    public void raiseLiked(String commentId) {
        //todo  限定一个用户 一条评论只能点赞一次
    }
}
