package com.example.springbotblogrestapi.service.impl;

import com.example.springbotblogrestapi.entity.Comment;
import com.example.springbotblogrestapi.entity.Post;
import com.example.springbotblogrestapi.exception.ResourceNotFoundException;
import com.example.springbotblogrestapi.payload.CommentDto;
import com.example.springbotblogrestapi.repository.CommentRepository;
import com.example.springbotblogrestapi.repository.PostRepository;
import com.example.springbotblogrestapi.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {


    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private ModelMapper mapper;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));

        comment.setPost(post);

        Comment newComment = commentRepository.save(comment);

        return mapToDTO(newComment);

    }

    @Override
    public List<CommentDto> getCommentByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    private CommentDto mapToDTO(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setEmail(comment.getEmail());
        commentDto.setName(comment.getName());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setName(commentDto.getName());
        return comment;
    }
}
