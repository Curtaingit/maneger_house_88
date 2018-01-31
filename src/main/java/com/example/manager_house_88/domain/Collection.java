package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.Bostype;
import com.example.manager_house_88.bos.Entry;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import sun.management.counter.perf.PerfInstrumentation;

import javax.persistence.*;


@Getter
@Setter
@Entity(name = "t_collection")
@Bostype("A08")
public class Collection extends BaseEntity {

    /*用户id*/
    private String userId;

    /*标的物id*/
    private String commodityId;



}
