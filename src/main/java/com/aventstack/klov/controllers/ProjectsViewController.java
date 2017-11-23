package com.aventstack.klov.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.aventstack.klov.domain.Project;
import com.aventstack.klov.repository.ProjectRepository;

@Controller
public class ProjectsViewController {

    @Autowired
    private ProjectRepository<Project, String> projectRepo;
    
    @GetMapping("/projects")
    public String projects(HttpSession session, Map<String, Object> model) {
        Optional<Project> project = Optional.ofNullable((Project) session.getAttribute("project"));
        model.put("project", project);
        Random random = new Random();
        int backImg = random.nextInt(3) + 1;
        model.put("lvback", "lv_back" + backImg);
        List<Project> projectList = projectRepo.findAll();
        model.put("projectList", projectList);
        
        return "projects";
    }
    
}
