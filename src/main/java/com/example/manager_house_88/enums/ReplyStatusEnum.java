package com.example.manager_house_88.enums;

import lombok.Getter;

@Getter
public enum ReplyStatusEnum {

    NOT_REPLY(0,"未答复"),
    REPLY(1, "答复");

    int code;
    String msg;

    ReplyStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
