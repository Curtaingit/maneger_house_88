package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */
@Repository
public interface CommodityRepo extends JpaRepository<Commodity, String> {
        List<Commodity> findByStatus(String status);
        Page<Commodity> findAll(Pageable pageable);
}
