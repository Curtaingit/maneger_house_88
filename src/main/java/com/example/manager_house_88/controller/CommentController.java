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
    public ResultVO save(@RequestBody Comment comment, Principal principal){
//        commentService.save(comment, PrincipalUtil.getOpenid(principal));
        return ResultVOUtil.success();
    }

/*    @PostMapping("/findbystatus")
    public ResultVO findByStatus(int status){
        return ResultVOUtil.success(commentService.findByStatus(status));
    }

    @PostMapping("/findbytype")
    public ResultVO findByType(int type){
        return ResultVOUtil.success(commentService.findByType(type));
    }*/

    @PostMapping("/changestatus")
    private ResultVO changeStatus(@RequestParam("commentid") String commentId){
        commentService.changeAuditStatus(commentId);
        return ResultVOUtil.success();
    }


}
