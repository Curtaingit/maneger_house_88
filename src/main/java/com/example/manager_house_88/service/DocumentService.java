package com.example.manager_house_88.service;

import com.example.manager_house_88.domain.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

public interface DocumentService {

    Document findOne(String documentId);

    Document save(String scheduleId,Document document);

    List<Document> findAll(Sort sort);

    Page<Document> findAll(Pageable pageable);

    void changeStatus(boolean status);

}
