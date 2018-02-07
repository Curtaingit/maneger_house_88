package com.example.manager_house_88.enums;

import lombok.Getter;

@Getter
public enum UserMessageEnum {

    COMMODITY_1("您参与的房屋:"),//1

    COMMODITY_2("恭喜您中"),

    SCHEDULE_MESSAGE_ONE("您已成功报名参与竞拍,该房屋名称:"),//1

    ;

    private  String msg;

    UserMessageEnum(String msg){

        this.msg =msg;
    }

}
