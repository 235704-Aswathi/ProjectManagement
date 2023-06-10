package org.example.service;

import org.example.domain.Task;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> viewTask(){
        return taskRepository.findAll();
    }
    @Override
    public Optional<Task> getTaskById(String id){
        return taskRepository.findById(id);
    }
    @Override
    public Task updateTaskByUser(Task task){
        return taskRepository.save(task);
    }
}
