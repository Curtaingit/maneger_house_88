package com.example.manager_house_88.controller;


import com.example.manager_house_88.domain.Reply;
import com.example.manager_house_88.enums.ReplyShowEnum;
import com.example.manager_house_88.service.ReplyService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/reply")
@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    /*添加一条问答*/
    @PostMapping("/save")
    public Object save(@RequestBody Reply reply){
        return replyService.save(reply);
    }

    /*删除一条问答*/
    @PostMapping("/delete")
    public Object delete (@RequestParam("replyid") String replyId){
        replyService.delete(replyId);
        return null;
    }

    /*查找标的物下的所有问答*/
    @PostMapping("/findbycommodityid")
    public Object findByCommodityId(@RequestParam("commodityid") String commodityId) throws Exception {
        return replyService.findByCommodityId(commodityId);
    }

    /*查找和客服经理有关的所有问答*/
    @PostMapping("/findbycustomermanagerid")
    public Object findByCustomerManagerId(@RequestParam("customermanagerid") String customerManagerId) {
        return replyService.findByCustomerManagerId(customerManagerId);
    }

    /*查找标的物下应该被显示的问答*/
    @PostMapping("/findbycommodityidshow")
    public Object findByIsShow(@RequestParam("commodityid") String commodityId) {
        return replyService.findByShowAndCommodityId(ReplyShowEnum.SHOW.getCode(),commodityId);
    }

    /*查找被回复或违背回复的所有问答*/
    @PostMapping("/findbyreply")
    public Object findByIsReply(@RequestParam("status")Integer status) {
        return replyService.findByStatus(status);
    }

    /*修改一条问答是否显示*/
    @PostMapping("/changeshow")
    public Object changeIsShow(@RequestParam("replyid") String replyId) {
        replyService.changeShow(replyId);
        return null;
    }

    /*答复一条问题*/
    @PostMapping("/answer")
    public Object answer(@RequestParam("replyid") String replyId,@RequestParam("answer") String answer) {
        replyService.answer(replyId,answer);
        return null;
    }

    @PostMapping("/findbyuserid")
    public Object findByUserId(Principal principal,@RequestParam(name="userid",required = false) String userId){
        return replyService.findByUserId(principal.getName());
    }


    /*查找一条通过replyId*/
    @PostMapping("/findone")
    public Object findone(@RequestParam("replyid") String replyId){
        return replyService.findOne(replyId);
    }


    @RequestMapping("/findall")
    public Object findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                          @RequestParam(name="size",required = false) Integer size,
                          @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return  replyService.findAll(sort);
        }
        Pageable pageable =new PageRequest(page-1,size,sort);
        return replyService.findAll(pageable);

    }

}
