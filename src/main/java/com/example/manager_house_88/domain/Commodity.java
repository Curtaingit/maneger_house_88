package com.example.manager_house_88.domain;

import com.example.manager_house_88.bos.BaseEntity;
import com.example.manager_house_88.bos.BosSet;
import com.example.manager_house_88.bos.Bostype;
import com.example.manager_house_88.bos.IBosSet;
import com.example.manager_house_88.enums.CommodityStateEnum;
import com.example.manager_house_88.enums.CommodityStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/*标的物*/

@Getter
@Setter
@Bostype("A04")
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
    private int status = CommodityStatusEnum.LISTED.getCode();

    /*规格*/
    private String standard;

    /*坐标*/
    private String coordinate;

    /*热度*/
    private int sort;

    /*底价*/
    private String price;

    /*看房人数*/
    private int observer;

    /*开标人数*/
    private int purchaser;

    /*进度*/
    private int state = CommodityStateEnum.NEW.getCode();

    /*开标时间*/
    private Long auctionTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Schedule> items = new HashSet<>();

    public IBosSet<Schedule> getItems() {
        return new BosSet(this.items, this);
    }
}
