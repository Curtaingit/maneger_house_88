package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.service.ScheduleService;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/findone")
    public Object findOne(@RequestParam("scheduleid") String scheduleId){
       return scheduleService.findOne(scheduleId);
    }

    @PostMapping("/create")
    public void save(@RequestParam("commodityid") String commodityId,@RequestBody Schedule schedule){
        scheduleService.create(commodityId,schedule);
        //todo
    }

    @PostMapping("/changewin")
    public void changeWin(@RequestParam("scheduleid") String scheduleId){
        scheduleService.changeWin(scheduleId);
    }

    @PostMapping("/findbyuserid")
    public Object findByUserId(@RequestParam("userid") String userId){
        return scheduleService.findByUserId(userId);
    }


    @RequestMapping("/findall")
    public Object findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                            @RequestParam(name="size",required = false) Integer size,
                            @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return  ResultVOUtil.success(scheduleService.findAll(sort));
        }
        Pageable pageable =new PageRequest(page-1,size,sort);
        return scheduleService.findAll(pageable);
    }

    @PostMapping("/changeprocess")
    public void changeProcess(@RequestParam("scheduleid") String scheduleId,
                                  @RequestParam("process") Integer process){
        scheduleService.changeProcess(scheduleId,process);
    }


    @PostMapping("/setamount")
    public void setAmount (@RequestParam("scheduleid") String scheduleId,
                               @RequestParam("amount") Long amount){
        scheduleService.setAmount(scheduleId,amount);
    }

}
