package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.enums.ResultExceptionEnum;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.repository.ScheduleRepo;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private CommodityService commodityService;

    /*设置为中标*/
    @Override
    public void changeWin(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setWin(true);
        changeProcess(scheduleId,6);
        scheduleRepo.save(schedule);
    }

    @Override
    public Page<Schedule> findAll(Pageable pageable) {
        return scheduleRepo.findAll(pageable);
    }

    @Override
    public List<Schedule> findAll(Sort sort) {
        return scheduleRepo.findAll(sort);
    }

    @Override
    public void changeAuditBail(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setAuditBail(true);
        scheduleRepo.save(schedule);
    }

    @Override
    public void changeProcess(String scheduleId, Integer process) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setProcessTime(schedule.getProcessTime()+","+System.currentTimeMillis());
        schedule.setProcess(process);
        scheduleRepo.save(schedule);
    }

    @Override
    public void uploadBailImage(String scheduleId, String bailImage) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setBailImage(bailImage);
        scheduleRepo.save(schedule);
    }

    @Override
    @Transactional
    public void setAmount(String scheduleId, Long amount) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setAmount(amount);
        scheduleRepo.save(schedule);
    }


    /*查找一条用户进度*/
    @Override
    public Schedule findOne(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        return schedule;
    }

    /*保存一条记录*/
    @Override
    public Schedule create(String commodityId, Schedule schedule) {
        Commodity commodity = commodityService.findOne(commodityId);
        if(commodity==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.COMMODITY_NOT_EXIST);
        }
        schedule.setProcess(1);
        schedule.setCommodityId(commodityId);
        scheduleRepo.save(schedule);
        return scheduleRepo.save(schedule);
    }


    /*保存一条记录*/
    @Override
    public void save(Schedule schedule) {
        scheduleRepo.save(schedule);

    }


    /*查找用户的所有进度信息*/
    @Override
    public Map findByUserId(String userId) {
        List<Schedule> schedules =scheduleRepo.findByUserId(userId);
        Map rs =new HashMap();
        for (Schedule schedule:schedules){
            Commodity commodity = commodityService.findOne(schedule.getCommodityId());
            rs.put(schedule.getId(),commodity);
        }
        return rs;
    }


}
