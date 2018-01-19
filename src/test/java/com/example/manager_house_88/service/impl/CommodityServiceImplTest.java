package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.repository.CommodityRepo;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.utils.BeanCopyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CommodityServiceImplTest {

    @Autowired
    CommodityRepo commodityRepo;
    @Autowired
    CommodityService commodityService;

    @Test
    public void update() {
//        Commodity commodity = new Commodity();
//        commodity.setSort(2222);
//        commodity.setPrice("10000000");
//        commodity.setDescription("xxxxx");
//        commodity.setCoordinate("xxxx");
//        Schedule schedule = new Schedule();
//        schedule.setUserId("11111");
//        commodity.getItems().add(schedule);
//        commodityService.update("jE5VcwaBHZyZpnk_2WfRo2A04", commodity);
//        Commodity rs=commodityRepo.findOne("nRCv_No6GRKAhvQpxHxVx3A04");
//        Set<Schedule> schedules = rs.getItems();
//        rs.getItems().clear();
//        BeanUtils.copyProperties(commodity,rs, BeanCopyUtil.getNullPropertyNames(commodity));
//        rs.getItems().addAll(schedules);
        /*commodityRepo.save(rs);*/
    }
}