package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.repository.ScheduleRepo;
import com.example.manager_house_88.repository.UserRepo;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.service.ScheduleService;
import com.example.manager_house_88.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        changeProcess(scheduleId,0);
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
        schedule.setProcessTime(System.currentTimeMillis());
        schedule.setProcess(process);
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
    public void create(String commodityId, Schedule schedule) {
//        schedule.setNumber(NumberUtil.getNumber());
        //todo : 取消一对多关系后 修改
        Commodity commodity = commodityService.findOne(commodityId);
        commodity.getItems().add(schedule);
        commodityService.save(commodity);

    }


    /*保存一条记录*/
    @Override
    public void save(Schedule schedule) {
        scheduleRepo.save(schedule);

    }


    /*查找用户的所有进度信息*/
    @Override
    public List<Commodity> findByUserId(String userId) {
        List<Commodity> commodityList =new ArrayList<>();
        List<Schedule> scheduleList=scheduleRepo.findByUserId(userId);
        for (Schedule schedule:scheduleList){
            String rs=schedule.getParent().getId();
            Commodity commodity = commodityService.findOne(rs);
            commodityList.add(commodity);
        }
//        commodityList = commodityService.findAll(new Sort("createtime"));
        return commodityList;
    }


}
