package com.example.manager_house_88.enums;


import lombok.Getter;

/*评论所属*/
@Getter
public enum CommentEnum {


    AGENTTYPE(1,"经纪人"),
    COMMODITYTYPE(2,"标的物"),

    WAITAUDITSTATUS(3,"等待审核"),
    AGREEAUDITSTATUS(4,"审核成功"),

    GENERAL(5,"普通评论"),
    NOBLE(6,"精选评论");





    int code;
    String msg;

    CommentEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
