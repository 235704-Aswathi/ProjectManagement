package org.example.service;

import org.example.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Comment addComment(Comment comment);

    Optional<Comment> getCommentById(String id);

    void deleteCommentById(String id);

    Optional<Comment> getComment(String taskId);
}
