package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Agency;
import com.example.manager_house_88.service.AgencyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaAuditing
public class AgencyControllerTest {

    @Autowired
    private AgencyService agencyService;

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void findOne() throws Exception {
        Agency agency = agencyService.findOne("SAKDjdakslJKLSADJ");
        System.out.println(agency);
    }

    @Test
    public void save() throws Exception {
        String url = "http://localhost:8080/house/agency/save";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept", "application/json");
        requestHeaders.set("Content-Type", "application/json;charset=utf-8");

        String jsonStr = "{\n" +
                "\"level\":8,\n" +
                "\"declaration\":\"傻乎乎\",\n" +
                "\"synopsis\":\"大西门\",\n" +
                "\"image\":\"xxxxxxxxx\",\n" +
                "\"name\":\"xxx中介公司\",\n" +
                "\"phone\":\"18156532485\",\n" +
                "\"headImg\":\"xxx\"\n" +
                "}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}