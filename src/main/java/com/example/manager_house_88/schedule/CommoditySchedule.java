package com.example.manager_house_88.schedule;

import com.example.manager_house_88.authwechat.SpringUtil;
import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.enums.CommodityStatusEnum;
import com.example.manager_house_88.service.CommodityService;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CommoditySchedule {


    /*定时任务  每天23时59分59秒执行*/
    @Scheduled(cron = "59 59 23 * * ?")
    public void cronJob(){
        CommodityService commodityService = (CommodityService) SpringUtil.getBean("commodityService");
        List<Commodity> commodityList = commodityService.findAll(new Sort("createtime"));

        /*修改房屋的状态  挂牌中 -> 竞标中*/
        for (Commodity commodity : commodityList){
            if (commodity.getAuctionTime()!=null && commodity.getAuctionTime()-2000<System.currentTimeMillis()){
                commodity.setStatus(CommodityStatusEnum.BIDDING.getCode());
            }
        }
    }
}
