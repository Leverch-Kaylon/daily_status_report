package com.dsr.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dsr.exceptionHandling.DataNotFound;
import com.dsr.mapping.MappingMapper;
import com.dsr.entity.Employee;
import com.dsr.repositories.EmployeeRepository;
import com.google.common.flogger.FluentLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dsr.dtos.ProjectDto;
import com.dsr.entity.Account;
import com.dsr.entity.Project;
import com.dsr.repositories.AccountRepository;
import com.dsr.repositories.ProjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProjectServiceImplementation implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	private static final FluentLogger logger = FluentLogger.forEnclosingClass();

	//EXPERIMENTAL endpoint - Combining get all projects and get single project into one, controlled by existence of account parameter
	@Override
	public List<ProjectDto> getProjectsUnderAccount(int account_id) {
		logger.atInfo().log("Service Layer - Project: Get projects under account");
		List<ProjectDto> dtoProjects = new ArrayList<>();
		if(account_id != 0){
			Project project=projectRepository.findProjectUnderAccounts(account_id).orElseThrow(() -> new DataNotFound("Account does not exist"));
			dtoProjects.add(MappingMapper.INSTANCE.toProjectDTOUnderAccount(project));
		}else{
			List<Project> allProjects = projectRepository.findAll();
			allProjects.forEach(p -> dtoProjects.add(MappingMapper.INSTANCE.toProjectDTO(p)));
		}

		return dtoProjects;
	}

	@Override
	public ProjectDto createProject(int accountId, Project project, int reportingManagerID) {
		logger.atInfo().log("Service Layer - Project: Create Project");
		Optional<Account> account = this.accountRepository.findById(accountId);
		project.setAccount_master(account.get());
		Optional<Employee> reportingManager = this.employeeRepository.findById(reportingManagerID);
		project.setReportingManager_master(reportingManager.get());
		project.setCreated_on(Date.valueOf(LocalDate.now()));
		project.setModified_on(Date.valueOf(LocalDate.now()));
		return MappingMapper.INSTANCE.toProjectDTO(this.projectRepository.save(project));
	}

	@Override
	public ProjectDto findProjectOnID(int projID){
		logger.atInfo().log("Service Layer - Project: Find Project By ID", projID);
		Project foundProject = projectRepository.findById(projID).orElseThrow(() -> new DataNotFound("No such project found with ID "+projID));
		return MappingMapper.INSTANCE.toProjectDTO(foundProject);
	}

	@Override
	public Project findProjectByIDReference(int projID){
		logger.atInfo().log("Service Layer - Project: Find Project Reference By ID", projID);
		ProjectDto proj = new ProjectDto();
		proj.setProject_id(projID);
		return entityManager.getReference(Project.class, proj.getProject_id());
	}

//	@Override
//	public void updateProject(int accountId, int projectId, Project project) {
//		Optional<Account> account = this.accountRepository.findById(accountId);
//		project.setAccount_master(account.get());
//		this.projectRepository.save(project);
//	}

	@Override
	public List<ProjectDto> getProjectsUnderManager(int reporting_manager, int account_id) {
		logger.atInfo().log("Service Layer - Project: Find Projects under manager", reporting_manager);
		List<Project> managerProjects = projectRepository.getProjectsUnderManager(reporting_manager, account_id);
		List<ProjectDto> projects = new ArrayList<>();
		managerProjects.forEach(p -> projects.add(MappingMapper.INSTANCE.toProjectDTO(p)));
		return projects;

	}



}