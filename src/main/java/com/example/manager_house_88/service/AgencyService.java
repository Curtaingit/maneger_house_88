package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Agency;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgencyService {

    Agency findOne(String agencyId);

    List<Agency> findAll(Sort sort);

    void add(Agency agency);

    void delete(String agencyId);

    void update(String agencyId, Agency agency);




}
