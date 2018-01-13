package com.example.manager_house_88.enums;


import lombok.Getter;

@Getter
public enum  ScheduleEnum {
    NEW(0,"报名看房"),
    WATCH(1,"线下看房"),
    SUBMIT_DOCUMENT(2,"提交标书"),
    PAY_DEPOSIT(3,"缴纳保证金"),
    COMPLETE_JOIN(4,"完成竞价报名"),
    ACTIONING(5,"竞价中");

    private  int code;
    private  String msg;

     ScheduleEnum(int code,String msg){
        this.code = code;
        this.msg =msg;
    }





}
