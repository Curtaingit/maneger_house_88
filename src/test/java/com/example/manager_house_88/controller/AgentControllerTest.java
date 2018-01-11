package com.example.manager_house_88.controller;

import com.example.manager_house_88.domain.Agent;
import com.example.manager_house_88.service.AgentService;
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


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaAuditing
public class AgentControllerTest {

    @Autowired
    private AgentService agentService;

    @Test
    public void findAll() throws Exception {
        List<Agent> agentList = agentService.findAll(new Sort("level"));
        System.out.println(agentList);
    }

    @Test
    public void findOne() throws Exception {
        Agent agent = agentService.findOne("HDKksajkskdnkjAHSO");
        System.out.println(agent);
    }

    @Test
    public void save() throws Exception {
        String url = "http://localhost:8080/house/agent/save";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept", "application/json");
        requestHeaders.set("Content-Type", "application/json;charset=utf-8");

        String jsonStr = "{\n" +
                "    \"level\": 8,\n" +
                "    \"estate\": \"瑞宏新城三期\",\n" +
                "    \"seniority\": \"2012.06.11\",\n" +
                "    \"declaration\": \"你的意见是我们进步的动力\",\n" +
                "    \"message\": \"留言。\",\n" +
                "    \"name\": \"婉格\",\n" +
                "    \"phone\": \"130\",\n" +
                "    \"company\": \"xxx中介\",\n" +
                "    \"store\": \"xxx门店\",\n" +
                "    \"serviceRange\": \"大南门\",\n" +
                "    \"headImg\": \"xxx\"\n" +
                "  }";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}