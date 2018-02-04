package com.example.manager_house_88.enums;


import lombok.Getter;

@Getter
public enum  CommentPraiseEnum {

    /*点赞*/
    PRAISE("1"),
    /*未点赞*/
    DISPRAISE("2");

    String msg;

    CommentPraiseEnum(String msg) {

        this.msg = msg;
    }
}
