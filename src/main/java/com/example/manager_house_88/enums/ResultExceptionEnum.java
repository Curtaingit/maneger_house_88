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
    COMMENT_NOT_EXIST(16,"评论不存在"),
    PROCESS_NOT_TRUE(17,"进度不正确"),
    REPLY_NOT_EXIST(18,"答复记录不存在"),
    PARAMETER_NOT_TRUE(19,"参数不正确"),
    CODE_NOT_TRUE(20,"验证码不正确"),
    DO_NOT_PASS(21,"验证不通过"),
    CUSTOMER_MANAGER_NOT_EXIST(22,"专家不存在")
    ;

    private Integer code;

    private String message;

    ResultExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
