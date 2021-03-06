package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.CustomerManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerManagerRepo  extends JpaRepository<CustomerManager, String> {

    CustomerManager findByNumber(String number);
}
