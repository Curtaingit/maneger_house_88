package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.repository.AdminRepo;
import com.example.manager_house_88.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return adminRepo.findByUsername(username);
    }
}
