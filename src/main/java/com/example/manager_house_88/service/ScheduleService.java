package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ScheduleService {

    /*查找一条用户进度*/
    Schedule findOne(String scheduleId);

    /*保存一条记录*/
    void create(String commodityId,Schedule schedule);

    /*查找用户的所有进度信息*/
    List<Schedule> findByUserId(String userId);


    /*设置为中标*/
    void changeWin(String scheduleId);

    Page<Schedule> findAll(Pageable pageable);

    List<Schedule> findAll(Sort sort);

    /*改变保证金审核状态*/
    void changeAuditBail(String scheduleId);

    /*改变用户进度*/
    void changeProcess(String schedule,Integer process);

    /*设置竞价*/
    void setAmount(String scheduleId, Long amount);
}
