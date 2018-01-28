package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import com.example.manager_house_88.enums.ReplyShowEnum;
import com.example.manager_house_88.enums.ReplyStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Bostype("A09")
@Entity(name = "t_reply")
public class Reply extends BaseEntity{

    /*客服经理id*/
    private String customerManagerId;

    /*用户id*/
    private String userId;

    /*标的物id*/
    private String commodityId;

    /*问题*/
    private String question;

    /*答复*/
    private String answer;

    /*是否显示*/
    private Integer isShow = ReplyShowEnum.NOT_SHOW.getCode();

    /*是否已回答*/
    private Integer status = ReplyStatusEnum.NOT_REPLY.getCode();


}
