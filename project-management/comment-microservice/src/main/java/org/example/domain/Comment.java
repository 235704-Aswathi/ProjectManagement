package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    private String commentId;
    private String description;
    private String taskId;

//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="comment_id", referencedColumnName = "task_id")
//    private Task task;

    public Comment(){

    }

    public Comment(String commentId, String description, String taskId) {
        this.commentId = commentId;
        this.description = description;
        this.taskId = taskId;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getDescription() {
        return description;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
