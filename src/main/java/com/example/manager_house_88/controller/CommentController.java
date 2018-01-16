package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Comment;
import com.example.manager_house_88.repository.CommentRepo;
import com.example.manager_house_88.service.CommentService;
import com.example.manager_house_88.utils.PrincipalUtil;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public void save(@RequestBody Comment comment){
        commentService.save(comment);
    }

    @PostMapping("/findbyauditstatus")
    public Object findByAuditStatus(@RequestParam("auditstatus") Integer auditStatus){
        return commentService.findByAuditStatus(auditStatus);
    }

    @PostMapping("/changeauditstatus")
    public void changeAuditsStatus(@RequestParam("commentid") String commentId){
        commentService.changeAuditStatus(commentId);
    }

    @PostMapping("/findbycommentstatus")
    public Object findByCommentStatus(@RequestParam("commentstatus") Integer commentStatus){
        return commentService.findByCommentStatus(commentStatus);
    }

    @PostMapping("/changecommentstatus")
    public void changeCommentStatus(@RequestParam("commentid") String commentId){
        commentService.changeCommentStatus(commentId);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam("commentid") String commentId){
        commentService.delete(commentId);
    }

    @PostMapping("/findbyascriptionid")
    public Object findByAscriptionId(@RequestParam("ascriptionid") String ascriptionId){
       return commentService.findByAscriptionId(ascriptionId);
    }

    @RequestMapping("/findall")
    public Object findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                            @RequestParam(name="size",required = false) Integer size,
                            @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return  ResultVOUtil.success(commentService.findAll(sort));
        }
        Pageable pageable =new PageRequest(page-1,size,sort);
        return commentService.findAll(pageable);
    }

}
