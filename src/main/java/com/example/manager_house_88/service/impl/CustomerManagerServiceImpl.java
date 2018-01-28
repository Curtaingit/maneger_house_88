package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.CustomerManager;
import com.example.manager_house_88.repository.CustomerManagerRepo;
import com.example.manager_house_88.service.CustomerManagerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManagerServiceImpl implements CustomerManagerService {

    @Autowired
    private CustomerManagerRepo customerManagerRepo;

    @Override
    public CustomerManager findOne(String customerManagerId) {
        return customerManagerRepo.findOne(customerManagerId);
    }

    @Override
    public void delete(String customerManagerId) {
        customerManagerRepo.delete(customerManagerId);
    }

    @Override
    public List<CustomerManager> findAll() {
        return customerManagerRepo.findAll();
    }

    @Override
    public CustomerManager save(CustomerManager customerManager) {
        return customerManagerRepo.save(customerManager);
    }

    @Override
    public CustomerManager update(String customerManagerId, CustomerManager customerManager) {

        CustomerManager rs = customerManagerRepo.findOne(customerManagerId);
        BeanUtils.copyProperties(customerManager,rs);
        return customerManagerRepo.save(rs);

    }
}
