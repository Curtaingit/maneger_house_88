package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Comment;
import com.example.manager_house_88.repository.CommentRepo;
import com.example.manager_house_88.service.CommentService;
import com.example.manager_house_88.utils.PrincipalUtil;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Comment comment){
    /*    commentService.save(comment);*/
        return ResultVOUtil.success();
    }

    @PostMapping("/findbyauditstatus")
    public ResultVO findByAuditStatus(@RequestParam("auditstatus") Integer auditStatus){
        return ResultVOUtil.success(commentService.findByAuditStatus(auditStatus));
    }

    @PostMapping("/findbytype")
    public ResultVO findByType(Integer type){
        return ResultVOUtil.success(commentService.findByType(type));
    }

    @PostMapping("/changeauditstatus")
    public ResultVO changeAuditsStatus(@RequestParam("commentid") String commentId){
        commentService.changeAuditStatus(commentId);
        return ResultVOUtil.success();
    }

    @PostMapping("/findbycommentstatus")
    public ResultVO findByCommentStatus(@RequestParam("commentstatus") Integer commentStatus){
        return ResultVOUtil.success(commentService.findByCommentStatus(commentStatus));
    }

    @PostMapping("/changecommentstatus")
    public ResultVO changeCommentStatus(@RequestParam("commentid") String commentId){
        commentService.changeCommentStatus(commentId);
        return ResultVOUtil.success();
    }

    @PostMapping("/delete")
    public ResultVO delete(@RequestParam("commentid") String commentId){
        commentService.delete(commentId);
        return ResultVOUtil.success();
    }



}
