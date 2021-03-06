package com.example.manager_house_88.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.manager_house_88.javabean.Invite;
import com.example.manager_house_88.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void save() {
        if(true){
            System.out.println("11");
        }else
        System.out.println("22");
    }

    @Test
    public void addMsg() {
        userService.addMsg("1111111","lalal");
    }

    @Test
    public void getMsg() {
        System.out.println(userService.getMsg("1111111"));
    }

    @Test
    public void addFeedback() {
        userService.addFeedback("123456","hahaha");
    }

    @Test
    public void getFeedback() {
        System.out.println( userService.getFeedback());
    }

    @Test
    public void addHistory() {
        userService.addHistory("1111111","R7oEVxRkHzGlbnLYrY-Zu0A04");
    }


    @Test
    public void findHistory(){
        userService.getHistory("1111111");
    }

    @Test
    public void getInvitemsg(){
        List<String> stringList = redisTemplate.opsForList().range("KE5uUfd1EgqYVScTFiK4D1A07"+"invite",0,300);
        List<Invite> invites = new ArrayList<>();
        for (String s :stringList){
            JSONObject parse = (JSONObject) JSONObject.parse(s);
            Invite invite = JSONObject.toJavaObject(parse, Invite.class);
            invites.add(invite);
        }
        System.out.println("");

    }

}