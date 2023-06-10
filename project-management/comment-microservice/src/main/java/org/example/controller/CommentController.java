package org.example.controller;

import org.example.domain.Comment;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        return ResponseEntity.ok().body(commentService.addComment(comment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable String id){
        final  var comment1=commentService.getCommentById(id);
        if(comment1.isPresent()){
            commentService.deleteCommentById(id);
            return ResponseEntity.ok().body(comment1.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/viewcomment/{taskid}")
    public ResponseEntity<Comment> getAllCommentsByTaskId(@PathVariable String taskId){
        final var commentOptional=commentService.getComment(taskId);
        if (commentOptional.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(commentOptional.get());
    }


}
