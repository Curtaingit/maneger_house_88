package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.repository.ScheduleRepo;
import com.example.manager_house_88.service.ScheduleService;
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
        return scheduleRepo.save(schedule);
    }

    @Override
    public List<Schedule> findByOpenid(String openid) {
        return scheduleRepo.findByOpenid(openid);
    }

    @Override
    public Schedule findByCommodityId(String commodityId) {
        return scheduleRepo.findByCommodityId(commodityId);
    }

    @Override
    public void changeStatus(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        //todo  修改进度
    }
}
