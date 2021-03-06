package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


/*代理人*/

@Getter
@Setter
@Bostype("A02")
@Entity(name = "t_agent")
public class Agent extends BaseEntity{

    /*星级*/
    private int level;

    /*主营楼盘*/
    private String estate;

    /*从业时间*/
    private String seniority;

    /*宣言*/
    private String declaration;

    /*姓名*/
    private String name;

    /*联系电话*/
    private String phone;

    /*所属公司*/
    private String company;

    /*门店*/
    private String store;

    /*服务商圈*/
    private String serviceRange;

    /*头像*/
    private String headImg;

}
