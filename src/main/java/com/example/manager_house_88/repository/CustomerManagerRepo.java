package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.CustomerManager;
import com.example.manager_house_88.domain.Document;
import com.example.manager_house_88.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerManagerRepo  extends JpaRepository<CustomerManager, String> {


}
