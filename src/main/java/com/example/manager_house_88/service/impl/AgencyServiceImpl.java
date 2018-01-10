package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Agency;
import com.example.manager_house_88.repository.AgencyRepo;
import com.example.manager_house_88.service.AgencyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;

public class AgencyServiceImpl implements AgencyService{

    @Autowired
    private AgencyRepo agencyRepo;

    /*根据id  查找一个代办机构*/
    @Override
    public Agency findOne(String agencyId) {
        return agencyRepo.findOne(agencyId);
    }

    /*查找所有代办机构   默认按星级 从高到低 */
    @Override
    public List<Agency> findAll(Sort sort) {
        return agencyRepo.findAll(sort);
    }

    /*添加一个 代办机构*/
    @Override
    public void add(Agency agency) {
        agencyRepo.save(agency);
    }

    /*删除一个代办机构*/
    @Override
    public void delete(String agencyId) {
        agencyRepo.delete(agencyId);
    }

    /*修改一个代办机构的信息*/
    @Override
    @Transactional
    public void update(String agencyId, Agency agency) {
        agencyRepo.save(agency);
        agencyRepo.delete(agencyId);
    }
}
