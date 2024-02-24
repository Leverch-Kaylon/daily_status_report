package com.m3support.demo.service;

import java.util.List;

import com.m3support.demo.dtos.ProjectDto;
import com.m3support.demo.entity.Project;


public interface ProjectService {
	
	List<Project> getAllProjects();
	
	List<Project> getProjectsUnderAccount(int account_id);
	
	List<ProjectDto> getProjectsDashboard();
	
	void createProject(int accountId, Project project,int reportingManagerID);
	
	void updateProject(int accountId, int projectId, Project project);
	
	List<Project> getProjectsUnderManager(int reporting_manager, int account_id);


}
