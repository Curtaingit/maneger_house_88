package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Reply;
import com.example.manager_house_88.enums.ReplyShowEnum;
import com.example.manager_house_88.enums.ReplyStatusEnum;
import com.example.manager_house_88.enums.ResultExceptionEnum;
import com.example.manager_house_88.exception.ManagerHouse88Exception;
import com.example.manager_house_88.repository.ReplyRepo;
import com.example.manager_house_88.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepo replyRepo;

    @Override
    public Reply findOne(String replyId) {
        return replyRepo.findOne(replyId);
    }

    @Override
    public void delete(String replyId) {
        replyRepo.delete(replyId);
    }

    @Override
    public List<Reply> findByCommodityId(String commodityId) {
        return replyRepo.findByCommodityId(commodityId);
    }

    @Override
    public List<Reply> findByCustomerManagerId(String customerManagerId) {
        return replyRepo.findByCustomerManagerId(customerManagerId);
    }



    @Override
    public List<Reply> findByStatus(Integer status) {
        return replyRepo.findByStatus(status);
    }

    @Override
    public List<Reply> findByShowAndCommodityId(Integer show, String commodityId) {
        return replyRepo.findByIsShowAndCommodityId(show,commodityId);
    }

    @Override
    public void changeShow(String replyId) {
        Reply reply = replyRepo.findOne(replyId);
        if (reply==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.REPLY_NOT_EXIST);
        }
        reply.setIsShow(ReplyShowEnum.SHOW.getCode());
        replyRepo.save(reply);
    }

    @Override
    public Reply save(Reply reply) {
        reply.setIsShow(ReplyShowEnum.NOT_SHOW.getCode());
        reply.setStatus(ReplyStatusEnum.NOT_REPLY.getCode());
        return replyRepo.save(reply);
    }

    @Override
    public List<Reply> findByUserId(String userId) {
        return replyRepo.findByUserId(userId);
    }

    @Override
    public void answer(String replyId,String answer) {
        Reply reply = replyRepo.findOne(replyId);
        if (reply==null){
            throw new ManagerHouse88Exception(ResultExceptionEnum.REPLY_NOT_EXIST);
        }
        reply.setAnswer(answer);
        reply.setStatus(ReplyStatusEnum.REPLY.getCode());
        replyRepo.save(reply);
    }

    @Override
    public List<Reply> findAll(Sort sort) {
        return replyRepo.findAll(sort);
    }

    @Override
    public Page<Reply> findAll(Pageable pageable) {
        return replyRepo.findAll(pageable);
    }
}
