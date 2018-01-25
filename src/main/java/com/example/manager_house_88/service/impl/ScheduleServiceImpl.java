package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.enums.ResultExceptionEnum;
import com.example.manager_house_88.enums.ScheduleEnum;
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
        String commodityId = schedule.getCommodityId();
        List<Schedule> scheduleList = finByCommodityId(commodityId);
        for(Schedule sche : scheduleList){
            if (scheduleId.equals(sche.getId())){
                sche.setWin(true);
                if (!ScheduleEnum.ACTIONING.getCode().equals(sche.getProcess())) {
                   throw new ManagerHouse88Exception(ResultExceptionEnum.PROCESS_NOT_TRUE);
                }
                changeProcess(scheduleId);
                scheduleRepo.save(sche);

            }else {
                if(schedule.getProcess()>= ScheduleEnum.COMPLETE_JOIN.getCode()){
                    sche.setProcess(ScheduleEnum.REFUND.getCode());
                    sche.setProcessTime(schedule.getProcessTime()+","+String.valueOf(System.currentTimeMillis()));
                    scheduleRepo.save(sche);
                }
            }
        }
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
        if(!ScheduleEnum.PAY_DEPOSIT.getCode().equals(schedule.getProcess())){
           throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        changeProcess(scheduleId);
        schedule.setAuditBail(true);
        scheduleRepo.save(schedule);
    }

    @Override
    public void setAgency(String scheduleId, String agencyId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setAgencyId(agencyId);
        changeProcess(scheduleId);
        scheduleRepo.save(schedule);
    }

    @Override
    public Schedule getSchedule(String userId, String commodityId) {
        Schedule schedule = scheduleRepo.findByUserIdAndCommodityId(userId, commodityId);
            return schedule;
    }

    @Override
    public void changeProcess(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setProcessTime(schedule.getProcessTime()+","+System.currentTimeMillis());
        schedule.setProcess(schedule.getProcess()+1);
        scheduleRepo.save(schedule);
    }

    @Override
    public void uploadBailImage(String scheduleId, String bailImage) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setBailImage(bailImage);
        if (!ScheduleEnum.SUBMIT_DOCUMENT.getCode().equals(schedule.getProcess())) {
            throw  new ManagerHouse88Exception(ResultExceptionEnum.PROCESS_NOT_TRUE);
        }
        changeProcess(scheduleId);
        scheduleRepo.save(schedule);
    }

    @Override
    public List<Schedule> finByCommodityId(String commodityId) {

       List<Schedule> schedules = scheduleRepo.findByCommodityId(commodityId);
        if (schedules==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        return schedules;
    }

    @Override
    @Transactional
    public void setAmount(String scheduleId, Long amount) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        else if(!ScheduleEnum.COMPLETE_JOIN.getCode().equals(schedule.getProcess())){
            throw new ManagerHouse88Exception(ResultExceptionEnum.PROCESS_NOT_TRUE);
        }
        schedule.setAmount(amount);
        changeProcess(scheduleId);
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
        schedule.setProcess(ScheduleEnum.NEW.getCode());
        schedule.setCommodityId(commodityId);
        schedule.setProcessTime(String.valueOf(System.currentTimeMillis()));
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
