package com.example.manager_house_88.utils;

import com.example.manager_house_88.authwechat.SpringUtil;
import org.springframework.data.redis.core.RedisTemplate;

public class UserMessageUtil {

    private static RedisTemplate redisTemplate= (RedisTemplate) SpringUtil.getBean("redisTemplate");

    public static void saveMsg(String MsgKey,String Msg){
        redisTemplate.opsForValue().set(MsgKey,Msg);
    }
}
