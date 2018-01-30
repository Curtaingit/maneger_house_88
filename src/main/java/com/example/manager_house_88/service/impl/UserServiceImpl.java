package com.example.manager_house_88.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.manager_house_88.domain.User;
import com.example.manager_house_88.javabean.Feedback;
import com.example.manager_house_88.javabean.Invite;
import com.example.manager_house_88.javabean.Message;
import com.example.manager_house_88.repository.UserRepo;
import com.example.manager_house_88.service.UserService;
import com.example.manager_house_88.utils.BeanCopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
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
    public List<String> getHistory(String userId) {
        List<String> rs = redisTemplate.opsForList().range(userId, 0, 15);
        return rs;
    }

    @Override
    public void addMsg(String userId, String msg) {
        String key = userId + "msg";
        Message message = new Message();
        message.setCreateTime(String.valueOf(System.currentTimeMillis()));
        message.setMessage(msg);

        String s = JSONObject.toJSONString(message);
        redisTemplate.opsForList().leftPush(key, s);
        User user = userRepo.findOne(userId);
        if (!user.isNewMsg()) {
            user.setNewMsg(true);
            userRepo.save(user);
        }
    }

    @Override
    public List<Message> getMsg(String userId) {
        //todo  可以优化
        List<String> list = redisTemplate.opsForList().range(userId + "msg", 0, 20);
        List<Message> rs = new ArrayList<>();
        for (String s : list) {
            JSONObject parse = (JSONObject) JSONObject.parse(s);
            Message message = JSONObject.toJavaObject(parse, Message.class);
            rs.add(message);
        }
        User user = userRepo.findOne(userId);
        user.setNewMsg(false);
        userRepo.save(user);
        return rs;
    }

    @Override
    public void addFeedback(String userId, String msg) {
        String key = "feedback";
        Feedback feedback = new Feedback();
        feedback.setMessage(msg);
        feedback.setUserId(userId);
        feedback.setCreateTime(String.valueOf(System.currentTimeMillis()));
        String s = JSONObject.toJSONString(feedback);
        redisTemplate.opsForList().leftPush(key, s);
        List<String> rs = redisTemplate.opsForList().range(key, 0, 300);
        /*当记录超过300条时  对数据库进行删除*/
        if (rs.size() >= 30) {
            redisTemplate.opsForList().trim(key, 0, 300);
        }
    }


    @Override
    public List<Feedback> getFeedback() {

        return redisTemplate.opsForList().range("feedback", 0, 300);

    }

    @Override
    public void into(String userId, String commodityId, String inviteCode) {
        Invite invite = new Invite(userId, commodityId,String.valueOf(System.currentTimeMillis()));
        String rs = JSONObject.toJSONString(invite);
        redisTemplate.opsForList().leftPush(inviteCode+"invite",rs);
    }


    @Override
    public void addHistory(String userId, String commodityId) {
        String key = userId + "history";
        List<String> rs = redisTemplate.opsForList().range(key, 0, 30);
        /*当记录超过30条时  对数据库进行删除*/
        if (rs.size() >= 30) {
            redisTemplate.opsForList().trim(key, 0, 15);
        }

        /*删除重复的记录*/
        for (String s : rs) {
            if (s.equals(commodityId)) {
                redisTemplate.opsForList().remove(key, 0, commodityId);
            }

        }
        /*添加记录*/
        redisTemplate.opsForList().leftPush(key, commodityId);
    }

    @Override
    public void update(Principal principal, User user) {
        User rs = findOne(principal);
        BeanUtils.copyProperties(user, rs, BeanCopyUtil.getNullPropertyNames(user));
        save(rs);
    }
}
