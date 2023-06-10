package org.example.service;

import org.example.domain.Task;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<Task> viewTask();
    Optional<Task> getTaskById(String id);

    Task updateTaskByUser(Task task);

}
