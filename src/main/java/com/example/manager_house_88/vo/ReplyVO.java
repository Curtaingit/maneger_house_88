package com.example.manager_house_88.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVO {

    /*客服经理id*/
    private String customerManagerId;

    /*客服经理头像*/
    private String customerManagerImage;

    /*客服经理名字*/
    private String customerManagerName;

    /*客服经理职称*/
    private String customerManagerTitle;

    /*标的物id*/
    private String commodityId;

    /*标的物图片*/
    private String commodityImage;

    /*问题*/
    private String question;

    /*答复*/
    private String answer;

    /*创建时间*/
    private long createtime;

    /*更新时间*/
    private long updatetime;
}
