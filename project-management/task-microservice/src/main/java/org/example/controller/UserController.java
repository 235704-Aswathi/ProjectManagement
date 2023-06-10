package org.example.controller;

import org.example.domain.Task;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<Task>> viewAllTask(){
        final var task1=userService.viewTask();
        if(task1.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(task1);
    }
    @PutMapping("/updatetask")
    public ResponseEntity<Task> updateProject (@RequestBody Task task){
        final var task1=userService.getTaskById(task.getTaskId());
        if (task1.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        userService.updateTaskByUser(task);
        return ResponseEntity.ok().body(task1.get());
    }

}
