package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
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
        schedule.setAuditBail(true);
        scheduleRepo.save(schedule);
    }

    @Override
    public void changeProcess(String scheduleId, Integer process) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        schedule.setProcessTime(schedule.getProcessTime()+","+System.currentTimeMillis());
        schedule.setProcess(process);
        scheduleRepo.save(schedule);
    }

    @Override
    public void uploadBailImage(String scheduleId, String bailImage) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        schedule.setBailImage(bailImage);
        scheduleRepo.save(schedule);
    }

    @Override
    @Transactional
    public void setAmount(String scheduleId, Long amount) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        schedule.setAmount(amount);
        scheduleRepo.save(schedule);
    }


    /*查找一条用户进度*/
    @Override
    public Schedule findOne(String scheduleId) {
        return scheduleRepo.findOne(scheduleId);
    }

    /*保存一条记录*/
    @Override
    public Schedule create(String commodityId, Schedule schedule) {
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
