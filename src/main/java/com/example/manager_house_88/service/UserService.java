package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.User;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

/**
 * Created by cx on 18-1-9.
 */


public interface UserService {

    List<User> findAll();

    User findOne(Principal principal);

    void save(User user);

    User findByOpenid(String openid);

}
