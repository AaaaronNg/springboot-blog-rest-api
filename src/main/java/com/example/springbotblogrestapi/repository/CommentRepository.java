package com.example.springbotblogrestapi.repository;

import com.example.springbotblogrestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostId(long postId);

}
