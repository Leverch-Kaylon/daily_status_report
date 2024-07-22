package com.dsr.service;

import java.util.List;

import com.dsr.dtos.ProjectDto;
import com.dsr.entity.Project;
import org.springframework.http.ResponseEntity;


public interface ProjectService {
	
	List<Project> getAllProjects();

	ResponseEntity<List<ProjectDto>> getProjectsUnderAccount(int account_id);
	
	//List<ProjectDto> getProjectsDashboard();

	ResponseEntity<ProjectDto> createProject(int accountId, Project project, int reportingManagerID);
	
	//void updateProject(int accountId, int projectId, Project project);

	ResponseEntity<List<ProjectDto>>  getProjectsUnderManager(int reporting_manager);

	public Project findProjectOnID(int projID);



	}
