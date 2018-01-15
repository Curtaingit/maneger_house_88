package com.example.manager_house_88.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class ScheduleControllerTest {

    @Test
    public void findOne() {
    }

    @Test
    public void save() {

        String url = "http://localhost:8080/house/schedule/create?commodityid=rrV__9viE9WivGIePUyir3A04";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept", "application/json");
        requestHeaders.set("Content-Type", "application/json;charset=utf-8");

        String jsonStr = "{\n" +
                "    \"userid\": \"oCiAMj5DyYWZbPauWbkFO4Y8CrHo\",\n" +
                "    \"state\": \"3\",\n" +
                "    \"agencyId\": \"uzUwcckIGCaQDYtw6B4yu3A01\",\n" +
                "    \"agentId\": \"dgJ3TQtkGRqWS4SUPRm0X2A02\",\n" +
                "    \"amount\":\"1000000000\",\n" +
                "    \"watchTime\": \"1523050215253\",\n" +
                "    \"auctionTime\": \"166555555555\"\n" +
                "  }";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);
        System.out.println(jsonData);


    }

    @Test
    public void findByOpenid() {
    }

    @Test
    public void findByCommodityId() {
    }
}