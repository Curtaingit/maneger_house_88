package com.example.manager_house_88.enums;


import lombok.Getter;

/*评论所属*/
@Getter
public enum CommentEnum {


    AGENT_TYPE(1,"经纪人"),
    COMMODITY_TYPE(2,"标的物"),

    WAIT_AUDIT_STATUS(3,"等待审核"),
    AGREE_AUDIT_STATUS(4,"审核成功"),

    GENERAL(5,"普通评论"),
    NOBLE(6,"精选评论");





    int code;
    String msg;

    CommentEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
