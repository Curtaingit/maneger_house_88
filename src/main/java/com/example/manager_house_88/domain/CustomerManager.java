package com.example.manager_house_88.domain;


import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Bostype("A10")
@Entity(name = "t_customerManager")
public class CustomerManager extends BaseEntity{

    /*头像*/
    private String image;

    /*名字*/
    private String name;

    /*职称*/
    private String title;
}
