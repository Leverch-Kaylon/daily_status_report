package com.m3support.demo.service;

import java.util.List;
import java.util.Optional;

import com.m3support.demo.entity.Employee;
import com.m3support.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3support.demo.dtos.ProjectDto;
import com.m3support.demo.entity.Account;
import com.m3support.demo.entity.Project;
import com.m3support.demo.repositories.AccountRepository;
import com.m3support.demo.repositories.ProjectRepository;

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
	public List<Project> getProjectsUnderAccount(int account_id) {
		
		return projectRepository.findProjectsUnderAccounts(account_id);

	}
	
	
	@Override
	public List<ProjectDto> getProjectsDashboard() {
		
	
		return this.projectRepository.getProjectsDashboard();
		
	}

	@Override
	public void createProject(int accountId, Project project,int reportingManagerID) {
		Optional<Account> account = this.accountRepository.findById(accountId);
		project.setAccount_master(account.get());
		Optional<Employee> reportingManager = this.employeeRepository.findById(reportingManagerID);
		project.setReportingManager_master(reportingManager.get());
		this.projectRepository.save(project);
	}

	@Override
	public void updateProject(int accountId, int projectId, Project project) {
		Optional<Account> account = this.accountRepository.findById(accountId);
		project.setAccount_master(account.get());
		this.projectRepository.save(project);
	}

	@Override
	public List<Project> getProjectsUnderManager(int reporting_manager, int account_id) {
		return projectRepository.getProjectsUnderManager(reporting_manager, account_id);
		
	}



}