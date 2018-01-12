package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Agency;
import com.example.manager_house_88.domain.Agent;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AgencyService {

    /*根据id  查找一个代办机构*/
    Agency findOne(String agencyId);

    /*查找所有代办机构   默认按星级 从高到低 */
    List<Agency> findAll(Sort sort);

    /*添加一个 代办机构*/
    void save(Agency agency);

    /*删除一个代办机构*/
    void delete(String agencyId);

    /*修改一个代办机构的信息*/
    void update(String agencyId, Agency agency);

    /*根据编号查询一个代理机构*/
    Agency findByNumber(String number);


}
