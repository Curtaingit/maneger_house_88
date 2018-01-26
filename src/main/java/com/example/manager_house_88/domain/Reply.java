package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
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

    /*标的物id*/
    private String commodityId;

    /*问题*/
    private String question;

    /*答复*/
    private String answer;

    /*是否显示*/
    private int show;

    /*是否已回答*/
    private int status;


}
