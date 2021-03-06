package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = {},methods ={RequestMethod.GET,RequestMethod.POST, RequestMethod.OPTIONS})
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/findone")
    public Object findOne(@RequestParam("scheduleid") String scheduleId){
       return scheduleService.findOne(scheduleId);
    }

    @PostMapping("/create")
    public Object save(@RequestParam("commodityid") String commodityId, @RequestBody Schedule schedule,Principal principal){
        return scheduleService.create(commodityId,schedule,principal.getName());
    }

//    @PostMapping("/create")
//    public Object save(@RequestParam("commodityid") String commodityId, @RequestBody Schedule schedule,@RequestParam("userid")String userId
//    ){
//        return scheduleService.create(commodityId,schedule,userId);
//    }

    @PostMapping("/changewin")
    public Object changeWin(@RequestParam("scheduleid") String scheduleId){
        scheduleService.changeWin(scheduleId);
        return "操作成功";


    }

    @PostMapping("/resultpublicized")
    public Object resultPublicized(@RequestParam("commodityid") String commodityId){
        return scheduleService.resultPublicized(commodityId);
    }

    @PostMapping("/findbyuserid")
    public Object findByUserId(Principal principal){
        return scheduleService.findByUserId(principal.getName());
    }

//    userId方法
//    @PostMapping("/findbyuserid")
//    public Object findByUserId(@RequestParam("userid") String userId
//    ){
//        return scheduleService.findByUserId(userId);
//    }
//

    @PostMapping("/setagency")
    public Object setAgency(@RequestParam("scheduleid") String scheduleId,@RequestParam("agencyid") String agencyId){
        scheduleService.setAgency(scheduleId,agencyId);
        return "操作成功";
    }

    @RequestMapping("/findall")
    public Object findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                            @RequestParam(name="size",required = false) Integer size,
                            @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return  scheduleService.findAll(sort);
        }
        Pageable pageable =new PageRequest(page-1,size,sort);
        return scheduleService.findAll(pageable);
    }

    @PostMapping("/changeprocess")
    public Object changeProcess(@RequestParam("scheduleid") String scheduleId){
        scheduleService.changeProcess(scheduleId);
        return "操作成功";
    }


    @PostMapping("/setamount")
    public Object setAmount (@RequestParam("scheduleid") String scheduleId,
                               @RequestParam("amount") Long amount){
        scheduleService.setAmount(scheduleId,amount);
        return "操作成功";
    }

    @PostMapping("/changeauditbail")
    public Object changeAuditBail (@RequestParam("scheduleid")String scheduleId){
        scheduleService.changeAuditBail(scheduleId);
        return "操作成功";
    }

    @PostMapping("/uploadbailimage")
    public Object uploadBailImage(@RequestParam("scheduleid")String scheduleId,@RequestParam("bailimage") String bailImage){
        scheduleService.uploadBailImage(scheduleId,bailImage);
        return "操作成功";
    }

    @PostMapping("/findbycommodityid")
    public Object findByCommodityId(@RequestParam("commodityid") String commodityId){
        return scheduleService.findByCommodityId(commodityId);
    }

    //userid     K
    @PostMapping("/getschedule")
    public Object getSchedule(Principal principal,@RequestParam("commodityid") String commodityId,@RequestParam(name = "userid",required = false)String userId){
        return scheduleService.getSchedule(principal.getName(),commodityId);
    }


}
