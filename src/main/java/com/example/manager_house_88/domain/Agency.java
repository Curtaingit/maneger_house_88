package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;

/*代理机构domain*/

@Setter
@Getter
@Entity(name = "t_agency")
public class Agency extends BaseEntity {

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

}
