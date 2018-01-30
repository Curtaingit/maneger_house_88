package com.example.manager_house_88;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.manager_house_88.javabean.Feedback;
import com.example.manager_house_88.utils.DesUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public void stringDes() {
        try {
            String test = "eFMtX2EjEnCO1vyixmg871A04";
            //注意这里，自定义的加密的KEY要和解密的KEY一致，这就是钥匙，如果你上锁了，却忘了钥匙，那么是解密不了的
            DesUtils des = new DesUtils("leemenz"); //自定义密钥
            System.out.println("加密前的字符：" + test);
            System.out.println("加密后的字符：" + des.encrypt(test));
            System.out.println("解密后的字符：" + des.decrypt(des.encrypt(test)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void redisSaveList() {
//
//          List<String> list2=new ArrayList<String>();
//          list2.add("b1");
//          list2.add("b2");
//          list2.add("b3");

        List<Object> list = new ArrayList<>();
        Feedback feedback = new Feedback("Gg", "10201020", "2222");
        Feedback feedback1 = new Feedback("Gg", "10201020", "3333");
        Feedback feedback2 = new Feedback("Gg", "10201020", "4444");
        list.add(feedback);
        list.add(feedback1);
        list.add(feedback2);

        String s = JSONObject.toJSONString(feedback);
        s = JSONArray.toJSONString(list);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
//          redisTemplate.opsForList().leftPush("testfeedback",s);
//          redisTemplate.opsForList().leftPush("testfeedback",s);
//          redisTemplate.opsForList().leftPush("testsave","a11");
//          redisTemplate.opsForList().leftPush("testsave","a21");
//          redisTemplate.opsForList().leftPush("testsave","a31");
//          redisTemplate.opsForList().leftPush("testsave","a11");
//          redisTemplate.opsForList().leftPush("testsave","a21");
//          redisTemplate.opsForList().leftPush("testsave","a31");

        List<String> ss = redisTemplate.opsForList().range("testfeedback", 0, 10);

        Page<String> strings = new PageImpl<>(ss, new PageRequest(1, 2), ss.size());


        System.out.println(ss);
        for (String sss : ss) {
            JSONObject jo = (JSONObject) JSON.parse(sss);
            Feedback feedback3 = JSONObject.toJavaObject(jo, Feedback.class);
            System.out.println(feedback3);
        }


//          redisTemplate.opsForList().trim("testsave",0,10);
//          Object testsave =  redisTemplate.opsForList().rightPop("testsave");
//          redisTemplate.opsForList().rightPop("testsave");
//          System.out.println(testsave);

          /*删除相同的一个元素（一条历史记录）*/
//          List<String> rs=(List<String>)redisTemplate.opsForList().range("test",0,10);
//          for (String s : rs){
//              if(s.equals("a1")){
//                  redisTemplate.opsForList().remove("test",0,"a1");
//              }
//          }

//          resultList1=(List<String>)redisTemplate.opsForList().range("testsave",0,20);
//          System.out.println("resultList1:"+resultList1);

    }
}
