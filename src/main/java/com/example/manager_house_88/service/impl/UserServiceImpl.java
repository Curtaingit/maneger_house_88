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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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
    private UserRepo userRepo;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> findAll(Sort sort) {
        return userRepo.findAll(sort);
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
    public List<String> findHistory(String userId) {
        /*设置redis存储时  采用的序列化方式*/
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        List<String> rs = redisTemplate.opsForList().range(userId,0,15);
        return rs;
    }

    @Override
    public void addHistory(String userId, String commodityId) {
        String key = userId;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        List<String> rs = redisTemplate.opsForList().range(key,0,30);
        /*当记录超过30条时  对数据库进行删除*/
        if (rs.size()>=30){
            redisTemplate.opsForList().trim(key,0,15);
        }
        /*删除重复的记录*/
        for (String s : rs) {
            if (s.equals(commodityId)) {
                redisTemplate.opsForList().remove(key, 0, commodityId);
            }

        }
        /*添加记录*/
        redisTemplate.opsForList().leftPush(key,commodityId);
    }

    @Override
    public void update(Principal principal, User user) {
        User rs = findOne(principal);
        BeanUtils.copyProperties(user, rs, BeanCopyUtil.getNullPropertyNames(user));
        save(rs);
    }
}
