package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepo extends JpaRepository<Comment,String> {

    List<Comment> findByAuditStatus(Integer auditStatus);

    List<Comment> findByCommentStatus(Integer commentStatus);

    List<Comment> findByAscriptionId(String ascriptionId);

    Page<Comment> findAll(Pageable pageable);
}
