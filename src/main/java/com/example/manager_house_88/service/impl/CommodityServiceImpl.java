package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.repository.CommodityRepo;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepo commodityRepo;

    /*通过commodityId查找一个标的物*/
    @Override
    public Commodity findOne(String commodityId) {
       Commodity commodity = commodityRepo.findOne(commodityId);
       commodity.setSort(commodity.getSort()+1);
       commodityRepo.save(commodity);
       return commodity;
    }

    /*查找所有标的物  默认按创建时间排序  倒序*/
    @Override
    public List<Commodity> findAll(Sort sort) {
        return commodityRepo.findAll(sort);
    }

    /*保存一个标的物*/
    @Override
    public Commodity save(Commodity commodity) {
        commodity.setNumber(NumberUtil.getNumber());
        return commodityRepo.save(commodity);

    }

    /*根据标的物状态(进度)查找*/
    @Override
    public List<Commodity> findByStatus(String status) {
        return commodityRepo.findByStatus(status);
    }

    /*查找所有标的物   分页*/
    @Override
    public Page<Commodity> findAll(Pageable pageable) {
        return commodityRepo.findAll(pageable);
    }


}
