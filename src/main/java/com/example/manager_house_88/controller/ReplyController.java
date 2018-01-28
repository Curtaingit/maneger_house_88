package com.example.manager_house_88.controller;


import com.example.manager_house_88.domain.Reply;
import com.example.manager_house_88.enums.ReplyShowEnum;
import com.example.manager_house_88.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/reply")
@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping("/save")
    public Object save(@RequestBody Reply reply){
        return replyService.save(reply);
    }

    @PostMapping("/delete")
    public Object delete (@RequestParam("replyid") String replyId){
        replyService.delete(replyId);
        return null;
    }

    @PostMapping("/findbycommodityid")
    public List<Reply> findByCommodityId(@RequestParam("commodityid") String commodityId) {
        return replyService.findByCommodityId(commodityId);
    }

    @PostMapping("/findbycustomermanagerid")
    public List<Reply> findByCustomerManagerId(@RequestParam("customermanagerid") String customerManagerId) {
        return replyService.findByCustomerManagerId(customerManagerId);
    }

    @PostMapping("/findbycommodityidshow")
    public List<Reply> findByIsShow(@RequestParam("commodityid") String commodityId) {
        return replyService.findByShowAndCommodityId(ReplyShowEnum.SHOW.getCode(),commodityId);
    }

    @PostMapping("/findbyreply")
    public List<Reply> findByIsReply(@RequestParam("status")Integer status) {
        return replyService.findByStatus(status);
    }

    @PostMapping("/changeshow")
    public void changeIsShow(@RequestParam("replyid") String replyId) {
        replyService.changeShow(replyId);
    }

    @PostMapping("/answer")
    public void answer(@RequestParam("replyid") String replyId,@RequestParam("answer") String answer) {
        replyService.answer(replyId,answer);
    }

    @RequestMapping("/findall")
    public Object findAll(){
        return replyService.findAll();
    }


    @PostMapping("/findone")
    public Object findone(@RequestParam("replyid") String replyId){
        return replyService.findOne(replyId);
    }

}
