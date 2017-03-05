package com.lemeshko.jpa.service;

import java.util.List;

import com.lemeshko.jpa.Project;

public interface ProjectService {

	public List<Project> findAll();

	public Project save(Project project);

}
