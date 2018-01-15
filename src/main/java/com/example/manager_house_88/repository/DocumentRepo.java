package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cx on 18-1-10.
 */

@Repository
public interface DocumentRepo extends JpaRepository<Document, String> {

    List<Document> findByUserId(String userId);
}
