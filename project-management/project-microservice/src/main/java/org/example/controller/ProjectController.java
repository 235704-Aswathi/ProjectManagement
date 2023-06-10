package org.example.controller;


import org.example.domain.Project;
import org.example.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        final var project1=projectService.getProject(project);
        if (project1.isEmpty()){
            return ResponseEntity.ok().body(projectService.addProject(project));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable String id){
        final  var project1=projectService.getProjectById(id);
        if(project1.isPresent()){
            projectService.deleteProjectById(id);
            return ResponseEntity.ok().body(project1.get());
        }
        return ResponseEntity.badRequest().build();

    }

}