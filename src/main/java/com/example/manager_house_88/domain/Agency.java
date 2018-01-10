package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity(name = "t_Agency")
public class Agency extends BaseEntity {

    /*宣言*/
    private String declaration;

    /*公司简介*/
    private String synopsis;

    /*公司图片*/
    private String image;

    /*公司名称*/
    private String name;

    /*公司电话*/
    private String phone;

    /*公司头像*/
    private String headImg;

}
