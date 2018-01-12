package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Schedule;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ScheduleService {

    Schedule findOne(String scheduleId);

    Schedule save(Schedule schedule);

/*    List<Schedule> findByOpenid(String openid);*/

    Schedule findByCommodityId(String commodityId);

    void changeStatus(String scheduleId);
}
