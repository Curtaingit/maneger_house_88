package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cx on 18-1-10.
 */


public interface UserRepo extends JpaRepository<User, String> {
    User findByOpenid(String openid);
}
