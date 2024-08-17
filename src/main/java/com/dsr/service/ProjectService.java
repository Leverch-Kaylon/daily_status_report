package com.dsr.service;

import java.util.List;

import com.dsr.dtos.ProjectDto;
import com.dsr.entity.Project;
import org.springframework.http.ResponseEntity;


public interface ProjectService {

	List<ProjectDto> getProjectsUnderAccount(int account_id);
	
	//List<ProjectDto> getProjectsDashboard();

	ProjectDto createProject(int accountId, Project project, int reportingManagerID);
	
	Project updateProject(int projectId,int reportingManager, int accountID, ProjectDto project);

	List<ProjectDto>  getProjectsUnderManager(int reporting_manager, int accountID);

	public ProjectDto findProjectOnID(int projID);

	public Project findProjectByIDReference(int projID);



	}
