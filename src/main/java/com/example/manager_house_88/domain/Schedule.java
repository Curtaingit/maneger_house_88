package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import com.example.manager_house_88.bos.Entry;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by cx on 18-1-10.
 */

@Getter
@Setter
@Bostype("A07")
@Entity(name = "t_schedule")
public class Schedule extends Entry {

    /*用户id*/
    private String userId;

    /*标的物id*/
    private String commodityId;

    /*经纪人id*/
    private String agentId;

    /*代办机构*/
    private String agencyId;

    /*竞价金额*/
    private Long amount;

    /*看房时间*/
    private Long watchTime;

    /*标书Id*/
    private String documentId;

    /*是否中标*/
    private boolean win;

    /*保证金图片*/
    private String bailImage;

    /*保证金是否审核*/
    private boolean auditBail;

    /*是否退款*/
    private boolean isRefund;

    @ManyToOne(fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    @JsonBackReference
    public Commodity getParent() {
        return (Commodity) super.getInnerParent();
    }

}
