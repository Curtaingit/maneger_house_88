package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Collection;
import com.example.manager_house_88.domain.Commodity;

import java.util.List;

public interface CollectionService {

    Collection findOne(String collectionId);

    Collection save(String userId ,String commodityId);

    void delete(String userId,String commodityId);

    List<Commodity> getCommodities(String userId);
}
