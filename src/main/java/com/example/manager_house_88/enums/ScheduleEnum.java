package com.example.manager_house_88.enums;


import lombok.Getter;

@Getter
public enum  ScheduleEnum {
    NEW(0,"报名看房"),
    WATCH(1,"线下看房"),
    SUBMIT_DOCUMENT(2,"提交标书"),
    PAY_DEPOSIT(3,"缴纳保证金"),
    COMPLETE_JOIN(4,"完成竞价报名"),
    ACTIONING(5,"竞价中"),
    SELECT_ANGENT(6,"选择代办公司"),
    CAPITAL_SUPERVISION(7,"资金监管"),
    HOUSE_TRANSFER(8,"不动产过户"),
    LICENSE(9,"领证"),
    PROPERTYDELIVERY(10,"物业交割"),
    CONFIRM(11,"确认交易"),
    COMMENT(12,"评论"),
    PAYMENTEND(13,"支付完成"),
    FINISH(14,"完成购房")

    ;
    

    private  int code;
    private  String msg;

     ScheduleEnum(int code,String msg){
        this.code = code;
        this.msg =msg;
    }





}
