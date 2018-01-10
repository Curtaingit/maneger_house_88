package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.utils.PrincipalUtil;
import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.repository.UserRepo;
import com.example.manager_house_88.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

/**
 * Created by cx on 18-1-9.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findOne(Principal principal) {
        return userRepo.findOne(PrincipalUtil.getOpenid(principal));
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findOne(String openid) {
        return userRepo.findOne(openid);
    }
}
