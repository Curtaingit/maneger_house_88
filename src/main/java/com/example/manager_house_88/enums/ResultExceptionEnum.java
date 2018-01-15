package com.example.manager_house_88.enums;

import lombok.Getter;

@Getter
public enum ResultExceptionEnum {

    AGENT_NOT_EXIST(10, "经纪人不存在"),
    AGENCY_NOT_EXIST(11, "代办公司不存在"),
    COMMODITY_NOT_EXIST(12, "标的物不存在"),
    DOCUMENT_NOT_EXIST(13, "标书不存在"),
    SCHEDULE_NOT_EXIST(14, "进度不存在"),
    USER_NOT_EXIST(15, "用户不存在"),

    ;

    private Integer code;

    private String message;

    ResultExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
