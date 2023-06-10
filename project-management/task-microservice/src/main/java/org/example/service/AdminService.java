package org.example.service;

import org.example.domain.Task;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    Task createTaskByAdmin(Task task);

    List<Task> viewTask();

    Optional<Task> getProjectById(String id);

    void deleteProjectById(String id);
}
