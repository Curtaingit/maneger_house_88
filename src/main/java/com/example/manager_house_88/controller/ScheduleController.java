package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.repository.ScheduleRepo;
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
    private ScheduleRepo scheduleRepo;

    @PostMapping("/findone")
    public ResultVO findOne(@RequestParam("scheduleid") String scheduleId){
       return ResultVOUtil.success(scheduleRepo.findOne(scheduleId));
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody Schedule schedule){
        scheduleRepo.save(schedule);
        return ResultVOUtil.success();
    }

    @RequestMapping("/findbyopenid")
    public ResultVO findByOpenid(Principal principal){
        List<Schedule> scheduleList = scheduleRepo.findByOpenid(PrincipalUtil.getOpenid(principal));
        return ResultVOUtil.success(scheduleList);
    }

    @PostMapping("/findbycommodityid")
    public ResultVO findByCommodityId(String commodityId){
        return ResultVOUtil.success(scheduleRepo.findByCommodityId(commodityId));
    }




}
