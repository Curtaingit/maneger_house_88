package com.example.manager_house_88.controller;

import com.example.manager_house_88.utils.BeanCopyUtil;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DocumentControllerTest {

    @Data
    class A{
        Integer a;
        String b;
        Boolean c;
    }

    @Data
    class B{
        Integer a;
        String b;
        Boolean c;
    }

    /*测试BeanUtils  拷贝时 即使本身字段为null  还是覆盖目标字段*/
    @Test
    public void copyProperties () {
        A a = new A();
        a.setB("aa");
        System.out.println(a);

        B b = new B();
        b.setA(22);

        BeanUtils.copyProperties(b,a, BeanCopyUtil.getNullPropertyNames(b));
        System.out.println(a);
        System.out.println(b);
    }


    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
        String url = "http://localhost:8080/house/document/save";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept", "application/json");
        requestHeaders.set("Content-Type", "application/json;charset=utf-8");

        String jsonStr = "{\n" +
                "    \"userId\": \"oCiAMj5DyYWZbPauWbkFO4Y8CrHo\",\n" +
                "    \"name\": \"陈哈哈\",\n" +
                "    \"phone\": \"12345678910\",\n" +
                "    \"identityImg\": \"哈哈哈哈哈哈\",\n" +
                "    \"familySize\": \"4\",\n" +
                "    \"maritalStatus\":\"1\",\n" +
                "    \"hobby\": \"打游戏\",\n" +
                "    \"religious\": \"无\",\n" +
                "    \"work\": \"学生\",\n" +
                "    \"purpose\": \"住\",\n" +
                "    \"payTime\": \"2222222222\",\n" +
                "    \"payWay\": \"全额现金\",\n" +
                "    \"otherMsg\": \"没有(ง •̀_•́)ง\",\n" +
                "    \"time\": \"110305025\",\n" +
                "    \"status\": \"5\",\n" +
                "    \"time\": \"110305025\"\n" +
                "  }";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);
        System.out.println(jsonData);
    }
}