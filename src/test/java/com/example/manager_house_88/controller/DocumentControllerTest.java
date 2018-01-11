package com.example.manager_house_88.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class DocumentControllerTest {

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
                "    \"openid\": \"oCiAMj5DyYWZbPauWbkFO4Y8CrHo\",\n" +
                "    \"name\": \"陈哈哈\",\n" +
                "    \"phone\": \"12345678910\",\n" +
                "    \"identityImg\": \"哈哈哈哈哈哈\",\n" +
                "    \"familySize\": \"4\",\n" +
                "    \"maritalStatus\":\"1\",\n" +
                "    \"Hobby\": \"打游戏\",\n" +
                "    \"religious\": \"无\",\n" +
                "    \"work\": \"学生\",\n" +
                "    \"purpose\": \"住\",\n" +
                "    \"payWay\": \"全额现金\",\n" +
                "    \"otherMsg\": \"没有(ง •̀_•́)ง\",\n" +
                "    \"status\": \"审核通过\"\n" +
                "  }";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);
        System.out.println(jsonData);
    }
}