package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,String> {

    List<Comment> findByAuditStatus(int status);

    List<Comment> findByType(int type);
}
