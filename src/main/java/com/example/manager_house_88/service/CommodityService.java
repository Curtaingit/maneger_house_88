package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Commodity;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

@Service
public interface CommodityService {

    Commodity findOne(String commodityId);

    List<Commodity> findAll(Sort sort);

    Commodity save(Commodity commodity);
}
