package com.example.manager_house_88.domain;


import com.example.manager_house_88.bos.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_User")
@Getter
@Setter
public class User extends BaseEntity {

    /*用户姓名*/
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

    //todo 浏览纪录    反馈    收藏

}