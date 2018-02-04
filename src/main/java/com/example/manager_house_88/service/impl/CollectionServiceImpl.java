package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Collection;
import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.repository.CollectionRepo;
import com.example.manager_house_88.service.CollectionService;
import com.example.manager_house_88.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionRepo collectionRepo;

    @Autowired
    private CommodityService commodityService;

    @Override
    public Collection findOne(String collectionId) {
        return collectionRepo.findOne(collectionId);
    }

    @Override
    public Collection save(String userId, String commodityId) {
        Collection collection =new Collection();
        collection.setUserId(userId);
        collection.setCommodityId(commodityId);
        return collectionRepo.save(collection);
    }

    @Transactional
    @Override
    public void delete(String userId, String commodityId) {
        collectionRepo.removeByUserIdAndCommodityId(userId, commodityId);
    }


    @Override
    public List<Commodity> getCommodities(String userId) {
        List<Commodity> rs = new ArrayList<>();
        List<Collection> list =collectionRepo.findByUserId(userId);
        for(Collection collection:list){
            Commodity commodity = commodityService.findOne(collection.getCommodityId());
            rs.add(commodity);
        }
        return rs ;
    }
}
