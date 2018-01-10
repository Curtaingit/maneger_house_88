package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Agent;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgentService {

    Agent findOne(String agentId);

    List<Agent> findAll(Sort sort);

    void add(Agent agent);

    void delete(String agentId);

    void update(String agentId, Agent agent);
}