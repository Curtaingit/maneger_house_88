package com.example.manager_house_88.enums;

import lombok.Getter;

@Getter
public enum UserMessageEnum {

    COMMODITY_1("您参与的房屋已开标!"),

    COMMODITY_2("您参与的房屋已结束竞拍"),

    COMMODITY_3("您已成功报名参与名为"),

    SCHEDULE_MESSAGE_ONE("您已完成报名!"),

    ;

    private  String msg;

    UserMessageEnum(String msg){

        this.msg =msg;
    }

}
