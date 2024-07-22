package com.dsr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dsr.mapping.MappingMapper;
import com.dsr.entity.Employee;
import com.dsr.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dsr.dtos.ProjectDto;
import com.dsr.entity.Account;
import com.dsr.entity.Project;
import com.dsr.repositories.AccountRepository;
import com.dsr.repositories.ProjectRepository;

@Service
public class ProjectServiceImplementation implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	
	@Override
	public List<Project> getAllProjects() {
		
		return projectRepository.findAll(); 
		
	}

	@Override
	public ResponseEntity<List<ProjectDto>> getProjectsUnderAccount(int account_id) {
		List<ProjectDto> dtoProjects = new ArrayList<>();
		for(Project projects :	projectRepository.findProjectsUnderAccounts(account_id)){
			dtoProjects.add(MappingMapper.INSTANCE.toProjectDTOUnderAccount(projects));
		}
		return new ResponseEntity<List<ProjectDto>>(dtoProjects,HttpStatus.OK);
	}

//	@Override
//	public List<Project> getProjectsUnderAccount(int account_id) {
//
//		return projectRepository.findProjectsUnderAccounts(account_id);
//
//	}
	
	
//	@Override
//	public List<ProjectDto> getProjectsDashboard() {
//
//
//		return this.projectRepository.getProjectsDashboard();
//
//	}

	@Override
	public ResponseEntity<ProjectDto> createProject(int accountId, Project project, int reportingManagerID) {
		Optional<Account> account = this.accountRepository.findById(accountId);
		project.setAccount_master(account.get());
		Optional<Employee> reportingManager = this.employeeRepository.findById(reportingManagerID);
		project.setReportingManager_master(reportingManager.get());
		return new ResponseEntity<ProjectDto>(MappingMapper.INSTANCE.toProjectDTO(this.projectRepository.save(project)), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ProjectDto>> getProjectsUnderManager(int reporting_manager) {
		List<ProjectDto> dtoProjects = new ArrayList<>();
		for(Project projects :	projectRepository.getProjectsUnderManager(reporting_manager)){
			dtoProjects.add(MappingMapper.INSTANCE.toProjectDTOUnderAccount(projects));
		}
		return new ResponseEntity<List<ProjectDto>>(dtoProjects,HttpStatus.OK);
	}

	public Project findProjectOnID(int projID){
		return projectRepository.findById(projID).get();
	}

//	@Override
//	public void updateProject(int accountId, int projectId, Project project) {
//		Optional<Account> account = this.accountRepository.findById(accountId);
//		project.setAccount_master(account.get());
//		this.projectRepository.save(project);
//	}

//	@Override
//	public List<Project> getProjectsUnderManager(int reporting_manager, int account_id) {
//		return projectRepository.getProjectsUnderManager(reporting_manager, account_id);
//
//	}



}