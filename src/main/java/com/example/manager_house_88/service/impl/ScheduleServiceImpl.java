package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.enums.CommodityStatusEnum;
import com.example.manager_house_88.enums.ResultExceptionEnum;
import com.example.manager_house_88.enums.ScheduleEnum;
import com.example.manager_house_88.enums.UserMessageEnum;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.repository.ScheduleRepo;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.service.ScheduleService;
import com.example.manager_house_88.service.UserService;
import com.example.manager_house_88.utils.UserMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private UserService userService;

    /*设置为中标*/
    @Override
    @Transactional
    public void changeWin(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        String commodityId = schedule.getCommodityId();
        Commodity commodity = commodityService.findOne(commodityId);
        commodity.setStatus(CommodityStatusEnum.COMPETITIVE.getCode());
        List<Schedule> scheduleList = findByCommodityId(commodityId);
        for (Schedule sche : scheduleList) {
            if (scheduleId.equals(sche.getId())) {
                sche.setWin(true);
                if (!ScheduleEnum.ACTIONING.getCode().equals(sche.getProcess())) {
                    throw new ManagerHouse88Exception(ResultExceptionEnum.PROCESS_NOT_TRUE);
                }
                scheduleRepo.save(sche);
                userService.addMsg(sche.getUserId(),"尊敬的用户：恭喜您成功中标,您中标的房屋名称:"+commodity.getDescription()+"，房屋编号:"+commodity.getNumber()+"。");
            } else {
                if (schedule.getProcess() >= ScheduleEnum.COMPLETE_JOIN.getCode()) {
                    sche.setProcess(ScheduleEnum.REFUND.getCode());
                    sche.setProcessTime(schedule.getProcessTime() + "," + String.valueOf(System.currentTimeMillis()));
                    scheduleRepo.save(sche);
                    userService.addMsg(sche.getUserId(),"尊敬的用户：很遗憾您未中标,您未中标的房屋名称:"+commodity.getDescription() +"，房屋编号:"+commodity.getNumber()+"。");
                }
            }
        }
        commodityService.save(commodity);
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
    @Transactional
    public void changeAuditBail(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        if (!ScheduleEnum.PAY_DEPOSIT.getCode().equals(schedule.getProcess())) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.PROCESS_NOT_TRUE);
        }
        Commodity commodity = commodityService.findOne(schedule.getCommodityId());
        /*报名人数增加*/
        commodity.setEnrolment(commodity.getEnrolment() + 1);
        changeProcess(scheduleId);
        schedule.setAuditBail(true);

        /*第一个人完成报名开标倒计时*/
        if (getCompleteBidding(commodity.getId()) == 1) {
            LocalDate date = LocalDate.now();
            date = date.plusDays(8);

            ZoneId zoneId = ZoneId.systemDefault();
            long time = date.atStartOfDay(zoneId).toEpochSecond();
            commodity.setAuctionTime(time * 1000);
        }
        commodityService.save(commodity);
        scheduleRepo.save(schedule);
        userService.addMsg(schedule.getUserId(), "尊敬的用户：恭喜您报名成功,您报名竞价的房屋名称:"+commodity.getDescription()+"，房屋编号:"+commodity.getNumber()+"。");
    }

    @Override
    public void setAgency(String scheduleId, String agencyId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule == null) {
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
        if (schedule == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setProcessTime(schedule.getProcessTime() + "," + System.currentTimeMillis());
        schedule.setProcess(schedule.getProcess() + 1);
        scheduleRepo.save(schedule);
    }

    @Override
    public void uploadBailImage(String scheduleId, String bailImage) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        schedule.setBailImage(bailImage);
        if (!ScheduleEnum.SUBMIT_DOCUMENT.getCode().equals(schedule.getProcess())) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.PROCESS_NOT_TRUE);
        }
        changeProcess(scheduleId);
        scheduleRepo.save(schedule);
    }

    @Override
    public List<Schedule> findByCommodityId(String commodityId) {

        List<Schedule> schedules = scheduleRepo.findByCommodityId(commodityId);
        if (schedules == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        return schedules;
    }

    @Override
    public List<Schedule> resultPublicized(String commodityId) {
        List<Schedule> schedules = scheduleRepo.findByCommodityId(commodityId);
        List<Schedule> rs = new ArrayList<>();
        for (Schedule schedule : schedules) {
            if (schedule.getProcess() >= ScheduleEnum.ACTIONING.getCode()) {
                rs.add(schedule);
            }
        }
        return rs;
    }

    @Override
    public void setAmount(String scheduleId, Long amount) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        } else if (!ScheduleEnum.COMPLETE_JOIN.getCode().equals(schedule.getProcess())) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.PROCESS_NOT_TRUE);
        }
        Commodity commodity = commodityService.findOne(schedule.getCommodityId());
        long time= commodity.getAuctionTime()+86400000L;
        long nowTime=System.currentTimeMillis();
        if (nowTime > time){
            return;
        }
        schedule.setAmount(amount);
        changeProcess(scheduleId);
        scheduleRepo.save(schedule);
        userService.addMsg(schedule.getUserId(),"尊敬的用户：恭喜您竞价成功,您参与竞价的房屋名称:"+commodity.getDescription()+"，房屋编号:"+commodity.getNumber()+"。");
    }


    /*查找一条用户进度*/
    @Override
    public Schedule findOne(String scheduleId) {
        Schedule schedule = scheduleRepo.findOne(scheduleId);
        if (schedule == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.SCHEDULE_NOT_EXIST);
        }
        return schedule;
    }

    /*保存一条记录*/
    @Override
    @Transactional
    public Schedule create(String commodityId, Schedule schedule, String userId) {
        Commodity commodity = commodityService.findOne(commodityId);
        Schedule rs = scheduleRepo.findByUserIdAndCommodityId(userId, commodityId);
        if (commodity == null) {
            throw new ManagerHouse88Exception(ResultExceptionEnum.COMMODITY_NOT_EXIST);
        }
        if (rs != null) {
            return rs;
        }
        commodity.setObserver(commodity.getObserver() + 1);
        schedule.setProcess(ScheduleEnum.NEW.getCode());
        schedule.setUserId(userId);
        schedule.setCommodityId(commodityId);
        schedule.setProcessTime(String.valueOf(System.currentTimeMillis()));
        commodityService.save(commodity);
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
        List<Schedule> schedules = scheduleRepo.findByUserId(userId);
        Map rs = new HashMap();
        for (Schedule schedule : schedules) {
            Commodity commodity = commodityService.findOne(schedule.getCommodityId());
            rs.put(schedule.getId(), commodity);
        }
        return rs;
    }

    @Override
    public Integer getCompleteBidding(String commodityId) {
        List<Schedule> scheduleList = scheduleRepo.findByCommodityId(commodityId);
        Integer count = 0;
        for (Schedule schedule : scheduleList) {
            if (ScheduleEnum.COMPLETE_JOIN.getCode().equals(schedule.getProcess())) {
                count++;
            }
        }
        return count;
    }
}
