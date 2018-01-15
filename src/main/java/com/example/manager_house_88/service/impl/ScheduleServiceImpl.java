package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.repository.ScheduleRepo;
import com.example.manager_house_88.service.ScheduleService;
import com.example.manager_house_88.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    /*设置为中标*/
    @Override
    public void changeWin(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        schedule.setWin(true);
        scheduleRepo.save(schedule);
    }

    @Override
    public void changeAuditBail(boolean auditBail) {

    }

    @Override
    public void changeProcess(Integer process) {

    }

    /*查找一条用户进度*/
    @Override
    public Schedule findOne(String scheduleId) {
        return scheduleRepo.findOne(scheduleId);
    }

    /*保存一条记录*/
    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }

    /*查找用户的所有进度信息*/
    @Override
    public List<Schedule> findByUserId(String userId) {
        return findByUserId(userId);
    }

}
