package com.example.groupproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

@Entity
@Table(name = "project")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String createdBy;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "project_developer", joinColumns = { @JoinColumn(name = "project_id") }, inverseJoinColumns = {
      @JoinColumn(name = "developer_id") })
  private List<Developer> developers = new ArrayList<>();

  public List<Developer> getDevelopers() {
    return this.developers;
  }

  public void setDevelopers(List<Developer> developers) {
    this.developers = developers;
  }

}