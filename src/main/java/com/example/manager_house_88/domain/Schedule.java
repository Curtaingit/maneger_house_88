package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cx on 18-1-10.
 */

@Getter
@Setter
@Bostype("A07")
@Entity(name = "t_schedule")
public class Schedule extends BaseEntity {

    /*用户id*/
    String userId;

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

    /*标书Id*/
    String documentId;

    /*是否中标*/
    boolean win;

}
