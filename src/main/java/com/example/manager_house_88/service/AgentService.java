package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Agent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AgentService {

    /*根据id 查找一个经纪人*/
    Agent findOne(String agentId);

    /*查找所有代理人  默认按星级排序  从高到低*/
    List<Agent> findAll(Sort sort);

    /*添加一个经纪人*/
    void save(Agent agent);

    /*删除一个经纪人*/
    void delete(String agentId);

    /*修改经纪人的信息*/
    void update(String agentId, Agent agent);

    /*根据编号查询一个经纪人*/
    Agent findByNumber(String number);

    /*查找所有经纪人   分页*/
    Page<Agent> findAll(Pageable pageable);
}
