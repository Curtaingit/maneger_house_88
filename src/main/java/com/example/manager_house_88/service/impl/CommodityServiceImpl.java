package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.enums.ResultExceptionEnum;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.repository.CommodityRepo;
import com.example.manager_house_88.service.CommodityService;
import com.example.manager_house_88.utils.BeanCopyUtil;
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
        if(commodity==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.COMMODITY_NOT_EXIST);
        }
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

    @Override
    public void changeStatus(String commodityId, Integer status) {
        Commodity commodity = commodityRepo.findOne(commodityId);
        commodity.setStatus(status);
        commodityRepo.save(commodity);
    }

    @Override
    public void changeState(String commodityId, Integer state) {
        Commodity commodity = commodityRepo.findOne(commodityId);
        if(commodity==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.COMMODITY_NOT_EXIST);
        }
        commodity.setState(state);
        commodityRepo.save(commodity);
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
        if(rs==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.COMMODITY_NOT_EXIST);
        }
        BeanUtils.copyProperties(commodity,rs,BeanCopyUtil.getNullPropertyNames(commodity));
        return commodityRepo.save(rs);
    }


}
