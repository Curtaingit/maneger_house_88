package com.example.manager_house_88.enums;

import lombok.Getter;

/**
 * Created by cx on 18-1-10.
 */


@Getter
public enum CommodityEnum {

    NEW(0,"新标的物"),
    WATCH(1, "看房"),
    APPLY(2, "报名"),
    AUCTION(3, "竞价"),
    BID_OPEN(4, "开标"),
    TRANSACTION(5, "交易"),
    FINISH(6, "完成");

    int code;
    String msg;

    CommodityEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
