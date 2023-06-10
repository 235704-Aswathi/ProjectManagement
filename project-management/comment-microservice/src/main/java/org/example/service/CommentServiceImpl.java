package org.example.service;

import org.example.domain.Comment;
import org.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> getCommentById(String id){
        return commentRepository.findById(id);
    }
    @Override
    public void deleteCommentById(String id){
        commentRepository.deleteById(id);
    }

    @Override
    public Optional<Comment> getComment(String taskId){
        return commentRepository.findCommentById(taskId);
    }
}
