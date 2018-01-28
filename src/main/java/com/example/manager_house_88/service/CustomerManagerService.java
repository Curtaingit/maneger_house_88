package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.CustomerManager;

import java.util.List;

public interface CustomerManagerService {

    CustomerManager findOne(String customerManagerId);

    void delete(String customerManagerId);

    List<CustomerManager> findAll();

    CustomerManager save(CustomerManager customerManager);

    CustomerManager update(String customerManagerId, CustomerManager customerManager);
}
