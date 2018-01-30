package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Reply;
import com.example.manager_house_88.vo.ReplyVO;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ReplyService {

    Reply save(Reply reply);

    Reply findOne(String replyId);

    void delete(String replyId);

    List<Reply> findByCommodityId(String commodityId);

    List<Reply> findByCustomerManagerId(String customerManagerId);

    List<Reply> findByShowAndCommodityId(Integer show,String commodityId);

    List<Reply> findByStatus(Integer status);

    void changeShow(String replyId);

    void answer(String replyId,String answer);

    List<Reply> findAll(Sort sort);

    List<ReplyVO> findByUserId(String userId);

    Page<Reply> findAll(Pageable pageable);
}
