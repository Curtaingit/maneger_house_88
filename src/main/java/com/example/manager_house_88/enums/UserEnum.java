package com.example.manager_house_88.enums;

import lombok.Getter;

@Getter
public enum UserEnum {

    USERASCRIPTION(1,"普通用户"),
    AGENTASCRIPTION(2,"经纪人");

    int code;
    String msg;

    UserEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
