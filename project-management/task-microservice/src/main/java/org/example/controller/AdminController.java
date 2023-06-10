package org.example.controller;

import org.example.domain.Task;
import org.example.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private Logger logger= LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        logger.info("task created successfully");
        return ResponseEntity.ok().body(adminService.createTaskByAdmin(task));
    }
    @GetMapping("/view")
    public ResponseEntity<List<Task>> viewAllTask(){
        final var tasks=adminService.viewTask();
        if (tasks.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(tasks);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Task> deleteProject(@PathVariable String id){
        final  var task1=adminService.getProjectById(id);
        if(task1.isPresent()){
            adminService.deleteProjectById(id);
            return ResponseEntity.ok().body(task1.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateProject (@RequestBody Task task){
        final var task1=adminService.getProjectById(task.getTaskId());
        if (task1.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        adminService.createTaskByAdmin(task);
        return ResponseEntity.ok().body(task1.get());
    }
}
