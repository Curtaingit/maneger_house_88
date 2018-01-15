package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Document;
import com.example.manager_house_88.repository.DocumentRepo;
import com.example.manager_house_88.service.DocumentService;
import com.example.manager_house_88.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

@Service
public class DocumentImpl implements DocumentService {


    @Autowired
    private DocumentRepo documentRepo;

    /*通过documentId查找一个标书*/
    @Override
    public Document findOne(String documentId) {
        return documentRepo.findOne(documentId);
    }

    /*保存一个标书*/
    @Override
    public Document save(Document document) {
        document.setNumber(NumberUtil.getNumber());
        return documentRepo.save(document);
    }

    /*查找所有标书 按时间排序   倒序                       */
    @Override
    public List<Document> findAll(Sort sort) {
        return documentRepo.findAll(sort);
    }

    @Override
    public void changeStatus(boolean status) {

    }


}
