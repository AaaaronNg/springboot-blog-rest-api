package com.example.springbotblogrestapi.service;

import com.example.springbotblogrestapi.entity.Comment;
import com.example.springbotblogrestapi.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentByPostId(long postId);
}
