package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.repository.ScheduleRepo;
import com.example.manager_house_88.service.ScheduleService;
import com.example.manager_house_88.utils.PrincipalUtil;
import com.example.manager_house_88.utils.ResultVOUtil;
import com.example.manager_house_88.vo.ResultVO;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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






}
