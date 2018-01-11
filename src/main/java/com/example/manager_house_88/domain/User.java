package com.example.manager_house_88.domain;


import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import lombok.Getter;
import lombok.Setter;
import org.omg.CORBA.INTERNAL;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "t_user")
@Getter
@Setter
@Bostype("A07")
public class User extends BaseEntity {

    /*姓名*/
    private String name;

    /*微信openid*/
    private String openid;

    /*性别*/
    private String sex;

    /*国家*/
    private String country;

    /*省份*/
    private String province;

    /*城市*/
    private String city;

    /*头像*/
    private String headImgUrl;

    /*手机号*/
    private String phone;

    /*普通用户 or 经纪人*/
    private int character;

    //todo 浏览纪录    反馈    收藏

}