package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "t_Agent")
public class Commodity extends BaseEntity{

    /*标的物图片*/
    private String image;

    /*标的物描述*/
    private String description;

    /*报名人数*/
    private String enrolment;

    /*标签*/
    private String label;

    /*状态*/
    private String status;

    /*规格*/
    private String standard;

    /*坐标*/
    private String coordinate;

    /*热度*/
    private String sort;

    /*底价*/
    private String price;

    /*看房人数*/
    private String observer;

    /*房屋编号*/
    private String number;


}
