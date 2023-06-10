package org.example.repository;

import org.example.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,String> {
    Optional<Comment> findCommentById(String taskId);
}
