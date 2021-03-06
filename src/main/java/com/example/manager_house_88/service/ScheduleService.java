package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface ScheduleService {

    /*查找一条用户进度*/
    Schedule findOne(String scheduleId);

    /*保存一条记录*/
    Schedule create(String commodityId, Schedule schedule,String userId);

    /*查找用户的所有进度信息*/
    Map findByUserId(String userId);

    /*设置为中标*/
    void changeWin(String scheduleId);

    Page<Schedule> findAll(Pageable pageable);

    List<Schedule> findAll(Sort sort);

    /*改变保证金审核状态*/
    void changeAuditBail(String scheduleId);

    /*改变用户进度*/
    void changeProcess(String schedule);

    /*设置竞价*/
    void setAmount(String scheduleId, Long amount);

    void save(Schedule schedule);

    /*上传保证金图片*/
    void uploadBailImage(String scheduleId, String bailImage);

    List<Schedule> findByCommodityId(String commodityId);

    void setAgency(String scheduleId, String agencyId);

    Schedule getSchedule(String userId,String commodityId);

    List<Schedule> resultPublicized(String commodityId);

    Integer getCompleteBidding(String commodityId);

}
