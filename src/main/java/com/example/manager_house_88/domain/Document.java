package com.example.manager_house_88.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cx on 18-1-10.
 */


@Getter
@Setter
@Entity(name = "t_document")
public class Document {

    /*姓名*/
    private String name;

    /*手机电话*/
    private String phone;

    /*二代身份证原件*/
    private String identityImg;

    /*家庭人数*/
    private String familySize;

    /*婚姻状况*/
    private int maritalStatus;

    /*兴趣爱好*/
    private String Hobby;

    /*宗教信仰*/
    private String religious;

    /*从事工作 */
    private String work;

    /*购房用途*/
    private String purpose;

    /*付款时间*/
    private String payTime;

    /*付款方式*/
    private String payWay;

    /*其他*/
    private String otherMsg;
}
