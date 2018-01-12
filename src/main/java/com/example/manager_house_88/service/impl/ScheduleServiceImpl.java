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

    @Override
    public Schedule findOne(String scheduleId) {
        return scheduleRepo.findOne(scheduleId);
    }

    @Override
    public Schedule save(Schedule schedule) {
        schedule.setNumber(NumberUtil.getNumber());
        return scheduleRepo.save(schedule);
    }

/*
    @Override
    public List<Schedule> findByOpenid(String openid) {
        return scheduleRepo.findByOpenid(openid);
    }
*/

    @Override
    public void changeStatus(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        //todo  修改进度
    }

    @Override
    public List<Schedule> findByUserId(String userId) {
        return findByUserId(userId);
    }

    @Override
    public List<Schedule> findByNumber(String number) {
        return findByNumber(number);
    }
}
