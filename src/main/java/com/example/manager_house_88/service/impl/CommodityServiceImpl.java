package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.repository.CommodityRepo;
import com.example.manager_house_88.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepo commodityRepo;

    /*通过commodityId查找*/
    @Override
    public Commodity findOne(String commodityId) {
       Commodity commodity = commodityRepo.findOne(commodityId);
       commodity.setSort(commodity.getSort()+1);
       commodityRepo.save(commodity);
       return commodity;
    }

    @Override
    public List<Commodity> findAll(Sort sort) {
        return commodityRepo.findAll(sort);
    }

    @Override
    public Commodity save(Commodity commodity) {
        return commodityRepo.save(commodity);
    }

}
