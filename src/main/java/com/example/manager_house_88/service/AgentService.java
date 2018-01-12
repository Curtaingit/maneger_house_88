package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Agent;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AgentService {

    /*根据id 查找一个代理人*/
    Agent findOne(String agentId);

    /*查找所有代理人  默认按星级排序  从高到低*/
    List<Agent> findAll(Sort sort);

    /*添加一个代理人*/
    void save(Agent agent);

    /*删除一个代理人*/
    void delete(String agentId);

    /*修改代理人的信息*/
    void update(String agentId, Agent agent);

    /*根据编号查询一个代理人*/
    Agent findByNumber(String number);
}
