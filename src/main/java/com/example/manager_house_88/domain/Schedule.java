package com.example.manager_house_88.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cx on 18-1-10.
 */

@Getter
@Setter
@Entity(name = "t_schedule")
public class Schedule {

    /*用户id*/
    String openid;

    /*进度*/
    String state;

    /*标的物id*/
    String commodityId;

    /*经纪人id*/
    String agentId;

    /*代办机构*/
    String agencyId;

    /*竞价金额*/
    Long amount;

    /*看房时间*/
    Long watchTime;

    /*竞拍时间*/
    Long auctionTime;

}
