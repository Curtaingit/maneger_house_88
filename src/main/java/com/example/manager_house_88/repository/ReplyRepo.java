package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Commodity;
import com.example.manager_house_88.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ReplyRepo  extends JpaRepository<Reply, String> {

    List<Reply> findByCommodityId(String commodityId);

    List<Reply> findByCustomerManagerId(String customerManagerId);

    List<Reply> findByStatus(Integer status);

    List<Reply> findByIsShowAndCommodityId(Integer show,String commodityId);

    List<Reply> findByUserId(String userId);

    Page<Reply> findAll(Pageable pageable);

    Reply findByNumber(String number);

}
