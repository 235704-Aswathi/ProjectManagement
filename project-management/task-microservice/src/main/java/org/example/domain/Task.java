package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
    @Id
    private String taskId;
    private String taskName;
    private String status;
    private String taskDescription;


    public Task(){

    }

    public Task(String taskId, String taskName, String status, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.taskDescription = taskDescription;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
