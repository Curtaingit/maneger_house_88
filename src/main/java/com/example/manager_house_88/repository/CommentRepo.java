package com.example.manager_house_88.repository;

import com.example.manager_house_88.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepo extends JpaRepository<Comment,String> {

    List<Comment> findByAuditStatus(Integer auditStatus);

    List<Comment> findByType(Integer type);

    List<Comment> findByCommentStatus(Integer commentStatus);
}
