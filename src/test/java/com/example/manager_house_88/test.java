package com.example.manager_house_88;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

      @Test
        public void redisSaveList(){
//
//          List<String> list2=new ArrayList<String>();
//          list2.add("b1");
//          list2.add("b2");
//          list2.add("b3");
          redisTemplate.setKeySerializer(new StringRedisSerializer());
          redisTemplate.setValueSerializer(new StringRedisSerializer());
//          redisTemplate.opsForList().leftPush("testsave","a11");
//          redisTemplate.opsForList().leftPush("testsave","a21");
//          redisTemplate.opsForList().leftPush("testsave","a31");
//          redisTemplate.opsForList().leftPush("testsave","a11");
//          redisTemplate.opsForList().leftPush("testsave","a21");
//          redisTemplate.opsForList().leftPush("testsave","a31");
          List<String> resultList1=redisTemplate.opsForList().range("testsave",0,10);
          System.out.println(resultList1);

          redisTemplate.opsForList().trim("testsave",0,10);
//          Object testsave =  redisTemplate.opsForList().rightPop("testsave");
//          redisTemplate.opsForList().rightPop("testsave");
//          System.out.println(testsave);
          /*删除相同的一个元素（一条历史记录）*/
//          List<String> resultList1=(List<String>)redisTemplate.opsForList().range("testsave",0,10);
//          for (String s : resultList1){
//              if(s.equals("a1")){
//                  redisTemplate.opsForList().remove("testsave",0,"a1");
//              }
//          }

          resultList1=(List<String>)redisTemplate.opsForList().range("testsave",0,20);
          System.out.println("resultList1:"+resultList1);

      }
}
