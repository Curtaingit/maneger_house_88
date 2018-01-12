package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Commodity;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

public interface CommodityService {

    Commodity findOne(String commodityId);

    List<Commodity> findAll(Sort sort);

    Commodity save(Commodity commodity);

    List<Commodity> findByStatus(String status);

    Page<Commodity> findAll(Pageable pageable);

    void delete(String commodityId);

    void setDetail(String commodityId, String detail);

    String getDetail(String commodityId);

    Commodity updata(String commodityId,Commodity commodity);

}
