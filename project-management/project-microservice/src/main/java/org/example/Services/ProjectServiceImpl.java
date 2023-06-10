package org.example.Services;

import org.example.domain.Project;
import org.example.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project addProject(Project project){
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> getProject(Project project) {
        return projectRepository.findById(project.getProjectId());

    }
    @Override
    public Optional<Project> getProjectById(String id){
        return projectRepository.findById(id);
    }
    @Override
    public void deleteProjectById(String id){
        projectRepository.deleteById(id);
    }
}