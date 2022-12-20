package com.example.springbotblogrestapi.repository;

import com.example.springbotblogrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
