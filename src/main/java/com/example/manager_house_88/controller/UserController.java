package com.example.manager_house_88.controller;


import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.javabean.Feedback;
import com.example.manager_house_88.service.UserService;
import com.example.manager_house_88.utils.ResultVOUtil;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = {}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findall")
    public Object findAll(@RequestParam(name = "sort", defaultValue = "createtime") String sortName,
                          @RequestParam(name = "size", required = false) Integer size,
                          @RequestParam(name = "page", required = false) Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, sortName);
        if (size == null || page == null) {
            return userService.findAll(sort);
        }
        Pageable pageable = new PageRequest(page - 1, size, sort);
        return userService.findAll(pageable);

    }


    @PostMapping("/findone")
    public Object findone(Principal principal){
        return userService.findOne(principal);
    }


    @PostMapping("/addhistory")
    public Object addHistory(Principal principal ,@RequestParam("commodityid") String commodityId){
        userService.addHistory(principal.getName(),commodityId);
        return null;
    }

    @PostMapping("/addmsg")
    public Object addMsg(Principal principal,String msg){
        userService.addMsg(principal.getName(),msg);
        return "操作成功";
    }


    @PostMapping("/save")
    public Object update(Principal principal, @RequestBody User user) {
        userService.update(principal, user);
        return null;
    }


//userId方法

//    @PostMapping("/addhistory")
//    public Object addHistory(@RequestParam("userid") String userId, @RequestParam("commodityid") String commodityId) {
//        userService.addHistory(userId, commodityId);
//        return null;
//    }
//
//    @PostMapping("/addmsg")
//    public Object addMsg(@RequestParam("userid") String userId, String msg) {
//        userService.addMsg(userId, msg);
//        return "操作成功";
//    }

//    @PostMapping("/getmsg")
//    public Object getMsg(@RequestParam("userid") String userId) {
//        return userService.getMsg(userId);
//    }


    @PostMapping("/addfeedback")
    public Object addFeedback(Principal principal, String msg) {
        userService.addFeedback(principal.getName(), msg);
        return "操作成功!";
    }

    @PostMapping("/getfeedback")
    public List<Feedback> getFeedback() {

        return userService.getFeedback();
    }

    @PostMapping("/gethistory")
    public Object getHistory(Principal principal) {
        return userService.getHistory(principal.getName());
    }

    @RequestMapping("/invite")
    public Object invite(Principal principal) {
        return principal.getName();
    }

    @PostMapping("/into")
    public Object into(Principal principal, @RequestParam("invitecode") String inviteCode, @RequestParam("commodityid") String commodityId) {
        userService.into(principal.getName(), commodityId, inviteCode);
        return null;
    }

    @RequestMapping("getinvitelist")
    public Object getInviteList(Principal principal){
        return userService.getInviteList(principal);
    }

    @RequestMapping("getnowtime")
    public Object getNowTime(){
        return System.currentTimeMillis();
    }
}
