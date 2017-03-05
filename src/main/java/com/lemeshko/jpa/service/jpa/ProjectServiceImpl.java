package com.lemeshko.jpa.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lemeshko.jpa.Project;
import com.lemeshko.jpa.service.ProjectService;

@Service("jpaProjectService")
@Repository
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@PersistenceContext
	private EntityManager emf;

	@Override
	@Transactional(readOnly = true)
	public List<Project> findAll() {
		List<Project> projects = emf.createNamedQuery("Project.getAllProjects", Project.class).getResultList();
		return projects;
	}

	@Override
	public Project save(Project project) {
		emf.persist(project);
		emf.flush();
		return project;
	}

}
