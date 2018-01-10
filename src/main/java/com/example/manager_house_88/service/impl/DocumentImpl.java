package com.example.manager_house_88.service.impl;

import com.example.manager_house_88.domain.Document;
import com.example.manager_house_88.repository.DocumentRepo;
import com.example.manager_house_88.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */
public class DocumentImpl implements DocumentService {


    @Autowired
    private DocumentRepo documentRepo;

    @Override
    public Document findOne(String documentId) {
        return documentRepo.findOne(documentId);
    }

    @Override
    public Document save(Document document) {
        return documentRepo.save(document);
    }

    @Override
    public List<Document> findAll(Sort sort) {
        return documentRepo.findAll(sort);
    }


}
