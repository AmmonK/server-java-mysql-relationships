package com.example.groupproject.controllers;

import java.util.List;

import com.example.groupproject.models.Project;
import com.example.groupproject.models.ProjectRepository;
import com.example.groupproject.models.WorkItem;
import com.example.groupproject.models.WorkItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class WorkItemController {

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private WorkItemRepository workItemRepository;

  @GetMapping("/{projectId}/workitems")
  public List<WorkItem> getWorkItemsByProjectId(@PathVariable Long projectId) {
    return workItemRepository.findByProjectId(projectId);
  }

  @PostMapping("/{projectId}/workitems")
  public WorkItem createWorkItem(@PathVariable Long projectId, @Validated @RequestBody WorkItem workItem) {
    Project foundProject = projectRepository.findById(projectId).orElse(null);
    if (foundProject != null) {
      workItem.setProject(foundProject);
      return workItemRepository.save(workItem);
    }
    return null;
  }

}