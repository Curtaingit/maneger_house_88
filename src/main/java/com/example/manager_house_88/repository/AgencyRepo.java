package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepo extends JpaRepository<Agency,String> {

    Agency findByNumber(String number);
}
