package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Agency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepo extends JpaRepository<Agency,String> {

    Agency findByNumber(String number);

    Page<Agency> findAll(Pageable pageable);
}
