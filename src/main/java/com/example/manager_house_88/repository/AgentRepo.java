package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepo extends JpaRepository<Agent,String> {

}
