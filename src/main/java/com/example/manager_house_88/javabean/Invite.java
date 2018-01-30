package com.example.manager_house_88.javabean;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invite {
    /*邀请时间*/
    private String InviteTime;

    /*被邀请用户的Id*/
    private String userId;

    /*标的物Id*/
    private String commodityId;

    public Invite(String userId, String commodityId,String inviteTime) {
        InviteTime = inviteTime;
        this.userId = userId;
        this.commodityId = commodityId;
    }

    public Invite() {
    }
}
