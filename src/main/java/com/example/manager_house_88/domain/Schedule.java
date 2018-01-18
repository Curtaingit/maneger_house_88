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

    /*标的物Id*/
    private String commodityId;

    /*用户id*/
    private String userId;

    /*看房人真实姓名*/
    private String realName;

    /*用户联系方式*/
    private String phone;

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

    /*用户流程进度*/
    private int process;

    /*是否退款*/
    private boolean isRefund;

    /*标书是否审核*/
    private boolean auditDocument;

    /*进程时间*/
    private String processTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @Access(AccessType.PROPERTY)
    @JsonBackReference
    public Commodity getParent() {
        return (Commodity) super.getInnerParent();
    }

}
