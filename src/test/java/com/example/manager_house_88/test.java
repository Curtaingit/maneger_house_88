package com.example.manager_house_88;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException ;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.example.manager_house_88.javabean.Feedback;
import com.example.manager_house_88.utils.AliyunMessageUtil;
import com.example.manager_house_88.utils.DesUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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
    @Test
    public  void time(){
/*        LocalDate date = LocalDate.now();
        System.out.println(date);
        Calendar calendar =  Calendar.getInstance();
        calendar.get(Calendar.)
        java.util.Date date1 = new java.util.Date();
        System.out.println(date1);
        calendar.set(calendar.get(Calendar.YEAR),calendar.get((Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)));
        calendar.set(Calendar.HOUR, 24);
//        calendar.set(date.getDayOfYear());

        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());

//        System.out.println(date);*/
        LocalDate date = LocalDate.now();
        date = date.plusDays(1);
        ZoneId zoneId = ZoneId.systemDefault();
        long time = date.atStartOfDay(zoneId).toEpochSecond();
        System.err.println(time);
        System.err.println(System.currentTimeMillis());
    }


    @Test
    public  void redisSet(){
        redisTemplate.opsForValue().set("testSet111","111");
        System.out.println(redisTemplate.opsForValue().get("testSet111"));
        redisTemplate.opsForValue().set("testSet111","222");
        System.out.println(redisTemplate.opsForValue().get("testSet111"));
    }

    @Test
    public void sendMsg() throws ClientException {
        String phoneNumber = "18267921108" ;
        String randomNum = createRandomNum(6);
        String jsonContent = "{\"code\":\"" + randomNum + "\"}";


        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("phoneNumber", phoneNumber);
        paramMap.put("msgSign", "温州房产圈");
        paramMap.put("templateCode", "SMS_125025751");
        paramMap.put("jsonContent", jsonContent);
        SendSmsResponse sendSmsResponse = AliyunMessageUtil.sendSms(paramMap);
        if(!(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK"))) {
            if(sendSmsResponse.getCode() == null) {
                System.out.println("sss");
            }
            if(!sendSmsResponse.getCode().equals("OK")) {
                System.out.println("no");
            }
        }
    }


    @Test
    public void a() throws ClientException {
        Integer integer = new Integer(9);
        boolean b = integer instanceof Object;
       Map map = new HashMap();
       map.put(null,null);
    }
    /**
     * 生成随机数
     * @param num 位数
     * @return
     */
    public static String createRandomNum(int num){
        String randomNumStr = "";
        for(int i = 0; i < num;i ++){
            int randomNum = (int)(Math.random() * 10);
            randomNumStr += randomNum;
        }
        return randomNumStr;
    }

}
