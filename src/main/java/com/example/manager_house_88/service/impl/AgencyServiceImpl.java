package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Agency;
import com.example.manager_house_88.enums.ResultExceptionEnum;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.repository.AgencyRepo;
import com.example.manager_house_88.service.AgencyService;
import com.example.manager_house_88.utils.BeanCopyUtil;
import com.example.manager_house_88.utils.NumberUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService{

    @Autowired
    private AgencyRepo agencyRepo;

    /*根据id  查找一个代办机构*/
    @Override
    public Agency findOne(String agencyId) {
        Agency agency = agencyRepo.findOne(agencyId);
        if(agency ==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.AGENCY_NOT_EXIST);
        }
        return agency;

    }

    /*查找所有代办机构   默认按星级 从高到低 */
    @Override
    public List<Agency> findAll(Sort sort) {
        return agencyRepo.findAll(sort);
    }

    /*添加一个 代办机构*/
    @Override
    public void save(Agency agency) {
//        agency.setNumber(NumberUtil.getNumber());
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
        Agency result = agencyRepo.findOne(agencyId);
        String number = result.getNumber();
        BeanUtils.copyProperties(agency,result, BeanCopyUtil.getNullPropertyNames(agency));
        agencyRepo.save(result);
    }

    /*根据编号查询一个代办机构*/
    @Override
    public Agency findByNumber(String number) {
        Agency agency = agencyRepo.findByNumber(number);
        if (agency==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.AGENCY_NOT_EXIST);
        }
        return agency;
    }

    /*查找所有代办机构   分页*/
    @Override
    public Page<Agency> findAll(Pageable pageable) {
        return agencyRepo.findAll(pageable);
    }
}
