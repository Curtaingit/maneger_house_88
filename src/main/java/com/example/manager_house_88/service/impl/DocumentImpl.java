package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Document;
import com.example.manager_house_88.domain.Schedule;
import com.example.manager_house_88.enums.ScheduleEnum;
import com.example.manager_house_88.repository.DocumentRepo;
import com.example.manager_house_88.service.DocumentService;
import com.example.manager_house_88.service.ScheduleService;
import com.example.manager_house_88.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

@Service
public class DocumentImpl implements DocumentService {


    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private DocumentRepo documentRepo;

    /*通过documentId查找一个标书*/
    @Override
    public Document findOne(String documentId) {
        return documentRepo.findOne(documentId);
    }

    /*保存一个标书*/
    @Override
    public Document save(@RequestParam("scheduleid") String scheduleId, Document document) {
        Schedule schedule = scheduleService.findOne(scheduleId);
        schedule.setProcess(ScheduleEnum.SUBMIT_DOCUMENT.getCode());
        document.setScheduleId(scheduleId);
        return documentRepo.save(document);
    }

    /*查找所有标书 按时间排序   倒序                       */
    @Override
    public List<Document> findAll(Sort sort) {
        return documentRepo.findAll(sort);
    }

    /*查找所有标书    分页*/
    @Override
    public Page<Document> findAll(Pageable pageable) {
        return documentRepo.findAll(pageable);
    }

    @Override
    public List<Document> findByUserId(String userId) {
        return documentRepo.findByUserId(userId);
    }

    @Override
    public void changeStatus(String documentId) {
        Document document = documentRepo.findOne(documentId);
        document.setStatus(true);
    }

   /* *//*修改标书审核状态*//*
    @Override
    public void changeStatus(@RequestParam("scheduleid") String scheduleId,boolean status) {
             Schedule schedule = scheduleService.findOne(scheduleId);
             schedule.setRefund(status);
    }*/


}
