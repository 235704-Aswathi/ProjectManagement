package org.example.service;

import org.example.domain.Task;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task createTaskByAdmin(Task task){
        return taskRepository.save(task);
    }

    @Override
    public List<Task> viewTask(){
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getProjectById(String id){
        return taskRepository.findById(id);
    }
    @Override
    public void deleteProjectById(String id){
        taskRepository.deleteById(id);
    }

}
