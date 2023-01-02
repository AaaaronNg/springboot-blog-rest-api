package com.example.springbotblogrestapi.controller;


import com.example.springbotblogrestapi.entity.Comment;
import com.example.springbotblogrestapi.payload.CommentDto;
import com.example.springbotblogrestapi.service.CommentService;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment( @PathVariable(value = "postId") long postId,
                                                     @Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto>  getCommentsByPostId(@PathVariable(value = "postId") Long postId){
        return commentService.getCommentByPostId(postId);
    }
}
