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
    public ResultVO findOne(@RequestParam("scheduleid") String scheduleId){
       return ResultVOUtil.success(scheduleService.findOne(scheduleId));
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody Schedule schedule){
        scheduleService.save(schedule);
        return ResultVOUtil.success();
    }

    @PostMapping("/changewin")
    public ResultVO changeWin(@RequestParam("scheduleid") String scheduleId){
        scheduleService.changeWin(scheduleId);
        return ResultVOUtil.success();
    }

    @PostMapping("/findbyuserid")
    public ResultVO findByUserId(@RequestParam("userid") String userId){
        return ResultVOUtil.success(scheduleService.findByUserId(userId));
    }


    @RequestMapping("/findall")
    public ResultVO findAll(@RequestParam(name = "sort",defaultValue = "createtime") String sortName,
                            @RequestParam(name="size",required = false) Integer size,
                            @RequestParam(name = "page",required = false) Integer page){
        Sort sort =new Sort(Sort.Direction.DESC,sortName);
        if(size==null||page==null){
            return  ResultVOUtil.success(scheduleService.findAll(sort));
        }
        Pageable pageable =new PageRequest(page,size,sort);
        return ResultVOUtil.success(scheduleService.findAll(pageable)) ;
    }

    @PostMapping("/changeprocess")
    public ResultVO changeProcess(@RequestParam("scheduleid") String scheduleId,
                                  @RequestParam("process") Integer process){
        scheduleService.changeProcess(scheduleId,process);
        return ResultVOUtil.success( );
    }


    @PostMapping("/setamount")
    public ResultVO setAmount (@RequestParam("scheduleid") String scheduleId,
                               @RequestParam("amount") Long amount){
        scheduleService.setAmount(scheduleId,amount);
        return ResultVOUtil.success();
    }

}
