package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,String> {

    Admin findByUsername(String username);

}

