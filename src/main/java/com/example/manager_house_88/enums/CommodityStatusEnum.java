package com.example.manager_house_88.enums;

import lombok.Getter;

/*标的物的状态*/
@Getter
public enum CommodityStatusEnum {

    LISTED(0,"挂牌中"),
    BIDDING(1, "竞价中"),
    COMPETITIVE(2, "已竞出"),
    UNCOMPETITIVE(3, "未竞出"),
    UNDERCARRIAGE(4,"已下架");

    int code;
    String msg;

    CommodityStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
