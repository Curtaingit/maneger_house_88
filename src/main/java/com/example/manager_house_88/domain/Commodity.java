package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/*标的物*/

@Getter
@Setter
@Entity(name = "t_commodity")
public class  Commodity extends BaseEntity{

    /*标的物图片*/
    private String images;

    /*标的物描述*/
    private String description;

    /*报名人数*/
    private int enrolment;

    /*标签*/
    private String label;

    /*状态*/
    private String status;

    /*规格*/
    private String standard;

    /*坐标*/
    private String coordinate;

    /*热度*/
    private int sort;

    /*底价*/
    private int price;

    /*看房人数*/
    private int observer;

    /*房屋编号*/
    private String number;

    /*开标人数*/
    private int purchaser;



}