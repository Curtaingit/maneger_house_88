package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Agent;
import com.example.manager_house_88.repository.AgentRepo;
import com.example.manager_house_88.service.AgentService;
import com.example.manager_house_88.utils.NumberUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepo agentRepo;

    /*根据id 查找一个代理人*/
    @Override
    public Agent findOne(String agentId) {
        return agentRepo.findOne(agentId);
    }

    /*查找所有代理人  默认按星级排序  从高到低*/
    @Override
    public List<Agent> findAll(Sort sort) {
        return agentRepo.findAll(sort);
    }

    /*添加一个代理人*/
    @Override
    public void save(Agent agent) {
        agent.setNumber(NumberUtil.getNumber());
        agentRepo.save(agent);
    }

    /*删除一个代理人*/
    @Override
    public void delete(String agentId) {
        agentRepo.delete(agentId);
    }

    /*修改代理人的信息*/
    @Override
    @Transactional
    public void update(String agentId, Agent agent) {
        Agent result = agentRepo.findOne(agentId);
        BeanUtils.copyProperties(agent,result);
        agentRepo.save(result);
    }

}
