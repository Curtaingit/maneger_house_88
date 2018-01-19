package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.service.CommodityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cx on 18-1-10.
 */

@EnableJpaAuditing
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommodityControllerTest {


    @Autowired
    CommodityService commodityService;

    @Test
    public void findOne() throws Exception {
//        Commodity commodity = commodityService.findOne("nRCv_No6GRKAhvQpxHxVx3A04");
//        Schedule schedule = new Schedule();
//        schedule.setUserId("11111");
//        schedule.setProcess(0);
//        commodity.getItems().add(schedule);
//        commodityService.save(commodity);
//        System.out.println(commodity);
    }

    @Test
    public void findAll() throws Exception {
        String jsonStr = "{\n" +
                "\"images\":\"xxxx\",\n" +
                "\"description\":\"大房子\",\n" +
                "\"label\":\"大东门\",\n" +
                "\"status\":\"0\",\n" +
                "\"standard\":\"3室一厅\",\n" +
                "\"coordinate\":\"hahaxapqo\",\n" +
                "\"observer\":\"6\",\n" +
                "\"number\":\"156486\",\n"+
                "\"price\":\"10000000\",\n"+
                "\"sort\":\"1000\",\n"+
                "\"purchaser\":\"5\",\n"+
                "\"enrolment\":\"7\"\n"+
                "}";
        System.out.println(jsonStr);

    }

    @Test
    public void save() throws Exception {

        String url = "http://localhost:8080/house/commodity/save";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept", "application/json");
        requestHeaders.set("Content-Type", "application/json;charset=utf-8");

        String jsonStr = "{\n" +
                "\"images\":\"xxxx\",\n" +
                "\"description\":\"小房子\",\n" +
                "\"label\":\"大东门\",\n" +
                "\"status\":\"0\",\n" +
                "\"standard\":\"3室一厅\",\n" +
                "\"coordinate\":\"225,666\",\n" +
                "\"observer\":\"6\",\n" +
                "\"number\":\"156486\",\n"+
                "\"price\":\"10000000\",\n"+
                "\"sort\":\"1000\",\n"+
                "\"purchaser\":\"5\",\n"+
                "\"enrolment\":\"7\"\n"+
                "}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);
        System.out.println(jsonData);
    }
    @Test
    public void update() throws Exception {
        String url = "http://localhost:8080/house/commodity/update?commodityid=jE5VcwaBHZyZpnk_2WfRo2A04";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept", "application/json");
        requestHeaders.set("Content-Type", "application/json;charset=utf-8");

        String jsonStr = "{\n" +
//                "\"images\":\"xxxx\",\n" +
//                "\"description\":\"大房子\",\n" +
//                "\"label\":\"大东门\",\n" +
//                "\"status\":\"0\",\n" +
                "\"standard\":\"mmmmmm\",\n" +
                "\"coordinate\":\"xmxmxxm\"\n" +
//                "\"observer\":\"6\",\n" +
//                "\"number\":\"156486\",\n"+
//                "\"price\":\"10000000\",\n"+
//                "\"sort\":\"1000\"\n"+
//                "\"purchaser\":\"5\",\n"+
//                "\"enrolment\":\"7\"\n"+
                "}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);
        System.out.println(jsonData);
    }



}