package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;

/*代理机构*/

@Setter
@Getter
@Bostype("A01")
@Entity(name = "t_agency")
public class Agency extends BaseEntity {

    /*星级*/
    private int level;

    /*描述*/
    private String declaration;

    /*宣言*/
    private String synopsis;

    /*图片*/
    private String image;

    /*名称*/
    private String name;

    /*联系电话*/
    private String phone;

    /*头像*/
    private String headImg;

    /*地址*/
    private String address;

}
