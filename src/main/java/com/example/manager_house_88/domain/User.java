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

    private String name;

    private String openId;

    private String sex;

    private String country;

    private String province;

    private String city;

    private String headImgUrl;

}