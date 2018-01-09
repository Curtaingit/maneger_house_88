package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity(name = "t_Agency")
public class Agency extends BaseEntity {

    private String declaration;
    private String synopsis;
    private String image;
    private String name;
    private String phone;
    private String headImg;

}
