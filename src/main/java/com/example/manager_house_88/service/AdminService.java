package com.example.manager_house_88.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AdminService extends UserDetailsService{
    UserDetails loadUserByUsername(String username);
}
