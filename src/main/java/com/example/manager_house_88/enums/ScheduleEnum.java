package com.example.manager_house_88.enums;

/**
 * Created by cx on 18-1-10.
 */

public enum ScheduleEnum {

    WATCH(0, "看房"),
    APPLY(1, "报名"),
    AUCTION(2, "竞价"),
    BID_OPEN(3, "开标"),
    TRANSACTION(4, "交易"),
    FINISH(5, "完成");

    int code;
    String msg;

    ScheduleEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
