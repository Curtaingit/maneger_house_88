package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CollectionRepo extends JpaRepository<Collection,String> {

    List<Collection> findByUserId(String userId);
}
