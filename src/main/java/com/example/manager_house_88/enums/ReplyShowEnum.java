package com.example.manager_house_88.enums;


import lombok.Getter;

@Getter
public enum ReplyShowEnum {

    NOT_SHOW(0,"不显示"),
    SHOW(1, "显示");

    int code;
    String msg;

    ReplyShowEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
