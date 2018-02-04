package com.example.manager_house_88.utils;

import com.example.manager_house_88.authwechat.SpringUtil;
import com.example.manager_house_88.enums.CommentPraiseEnum;
import org.springframework.data.redis.core.RedisTemplate;

public class RaiseLikedUtil {


    private static RedisTemplate redisTemplate= (RedisTemplate) SpringUtil.getBean("redisTemplate");

    public static void raise(String key,String likedKey){

        /*评论的总赞数加1*/
        String liked= (String) redisTemplate.opsForValue().get(likedKey);
        redisTemplate.opsForValue().set(likedKey, String.valueOf(Integer.valueOf(liked) + 1));

        /*将用户改为点赞状态*/
        redisTemplate.opsForValue().set(key, CommentPraiseEnum.PRAISE.getMsg());
    }

    public static void reduce(String key,String likedKey){

        /*评论的总赞数减1*/
        String liked = (String) redisTemplate.opsForValue().get(likedKey);
        redisTemplate.opsForValue().set(likedKey, String.valueOf(Integer.valueOf(liked) - 1));

        /*将用户改为未点赞状态*/
        redisTemplate.opsForValue().set(key, CommentPraiseEnum.DISPRAISE.getMsg());
    }
}
