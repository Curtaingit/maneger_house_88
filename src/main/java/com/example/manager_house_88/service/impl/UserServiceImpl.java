package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.repository.UserRepo;
import com.example.manager_house_88.service.UserService;
import com.example.manager_house_88.utils.BeanCopyUtil;
import com.example.manager_house_88.utils.PrincipalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

/**
 * Created by cx on 18-1-9.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> findAll(Sort sort) {
        return  userRepo.findAll(sort);
    }

    @Override
    public User findOne(Principal principal) {
        return userRepo.findOne(principal.getName());
    }

    @Override
    public User save(User user) {
       return userRepo.save(user);
    }

    @Override
    public User findByOpenid(String openid) {
        return userRepo.findByOpenid(openid);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    @Transactional
    public void update(Principal principal, User user) {
       User rs = findOne(principal);
        BeanUtils.copyProperties(user,rs, BeanCopyUtil.getNullPropertyNames(user));
        save(rs);
    }
}
