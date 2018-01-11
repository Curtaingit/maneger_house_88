package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cx on 18-1-10.
 */
@Repository
public interface CommodityRepo extends JpaRepository<Commodity, String> {

}
