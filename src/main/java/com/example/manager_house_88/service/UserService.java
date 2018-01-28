package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.jws.soap.SOAPBinding;
import java.security.Principal;
import java.util.List;

/**
 * Created by cx on 18-1-9.
 */


public interface UserService {

    List<User> findAll(Sort sort);

    User findOne(Principal principal);

    User save(User user);

    User findByOpenid(String openid);

    Page<User> findAll(Pageable pageable);

    void update(Principal principal, User user);

    void addHistory(String userId,String commodityId);

    List<String> findHistory(String userId);

}
