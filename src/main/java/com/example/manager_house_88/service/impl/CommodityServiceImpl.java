package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.repository.CommodityRepo;
import com.example.manager_house_88.service.CommodityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private CommodityRepo commodityRepo;

    /*通过commodityId查找一个标的物*/
    @Override
    public Commodity findOne(String commodityId) {
        Commodity commodity = commodityRepo.findOne(commodityId);
        commodity.setSort(commodity.getSort() + 1);
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
//        commodity.setNumber(NumberUtil.getNumber());
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

    /*通过id删除标的物*/
    @Override
    public void delete(String commodityId) {
        commodityRepo.delete(commodityId);
    }


    /*设置标的物详情*/
    @Override
    public void setDetail(String commodityId, String detail) {
        stringRedisTemplate.opsForValue().set(commodityId, detail);
    }

    /*获取标的物的详情*/
    @Override
    public String getDetail(String commodityId) {
        return stringRedisTemplate.opsForValue().get(commodityId);
    }


    /*更新标的物*/
    @Override
    @Transactional
    public Commodity update(String commodityId, Commodity commodity) {
        Commodity rs = commodityRepo.findOne(commodityId);
        rs.setCoordinate(commodity.getCoordinate());
        rs.setPrice(commodity.getPrice());
        rs.setSort(commodity.getSort());
        rs.setDescription(commodity.getDescription());
        rs.setImages(commodity.getImages());
        rs.setStatus(commodity.getStatus());
        rs.setStandard(commodity.getStandard());
        rs.setState(commodity.getState());
        rs.setLabel(commodity.getLabel());
//        BeanUtils.copyProperties(commodity, commodity);
        Commodity re =commodityRepo.save(rs);
        return re;
    }


}
