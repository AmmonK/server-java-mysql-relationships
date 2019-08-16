package com.example.groupproject.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
  List<WorkItem> findByProjectId(Long projectId);

  Optional<WorkItem> findByIdAndProjectId(Long id, Long projectId);
}