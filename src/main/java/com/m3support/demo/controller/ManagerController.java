package com.m3support.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.dtos.ManagerDto;
import com.m3support.demo.entity.Account;
import com.m3support.demo.entity.Project;
import com.m3support.demo.entity.Report;
import com.m3support.demo.repositories.AccountRepository;
import com.m3support.demo.repositories.ProjectRepository;
import com.m3support.demo.service.AccountService;
import com.m3support.demo.service.ProjectService;
import com.m3support.demo.service.ReportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ManagerController {

	@Autowired
	ReportService reportService;

	@Autowired
	ProjectService projectService;

	@Autowired
	AccountService accountService;
	

	// Methods used by manager to generate a PDF report.
	@GetMapping("/manager/{currentDate}")
	public String generateDSRReport(@PathVariable("currentDate") Date currentDate) throws Exception {

		return reportService.generateDSRReport(currentDate);

	}

	// Method that allows the manager to retrieve/view all projects.
	@GetMapping("/manager/viewProjects")
	public List<Project> getAllProjects() {

		return projectService.getAllProjects();
	}
	
	
	
	//Method that returns all the accounts under which a logged in manager has projects
//	@GetMapping("/manager/viewAccounts/{reporting_manager}")
//	public List<Account> getAccountsUnderManager(@PathVariable int reporting_manager){
//		return accountService.getAccountsFromManager(reporting_manager);
//	}
	
	//Method that returns all projects under a specific manager from an account
//	@GetMapping("/manager/viewProjectsUnderManager/{reporting_manager}/{account_id}")
//	public List<Project> getProjectsUnderManager(@PathVariable int reporting_manager, @PathVariable int account_id){
//		return projectService.getProjectsUnderManager(reporting_manager, account_id);
//	}
	

	// Method that returns all projects under an account.
//	@GetMapping("/manager/viewAllProjectsUnderAccount/{account_id}")
//	public List<Project> getAllProjectsUnderAccount(@PathVariable int account_id) {
//
//		return projectService.getProjectsUnderAccount(account_id);
//
//	}
	
	// Method that returns all employees DSR under specific project.
	@GetMapping("/manager/viewEmployeesUnderProject/{project_id}")
	public List<Report> getEmployeesDSRUnderProject(@PathVariable int project_id) {

		return reportService.getEmployeeDSRUnderProjects(project_id);

	}
	
	// Method returns all the manager's name's,id's and employee id's
//	@GetMapping("/manager/allmanagers")
//	public List<ManagerDto> getManagers() {
//		return accountService.getManagers();
//	}

	// Method that returns all employees DSR under specific project for
	// TODAY(Current date in system)
	@GetMapping("/manager/reports/{projectId}")
	public List<Report> getEmployeesDSRUnderProjectForToday(@PathVariable int projectId) {
		return reportService.getEmployeeDSRUnderProjectsForToday(projectId);
	}

	// Method return all employees reports under a projects for specific specified
	// date from datepicker
	@GetMapping("/manager/reports/{projectId}/{date}")
	public List<Report> getEmployeesDSRUnderProjectByDate(@PathVariable int projectId, @PathVariable Date date) {
		return reportService.getEmployeeDSRUnderProjectsByDate(projectId, date);
	}

	// Method to retrieve reports between selected dates
	@GetMapping("/manager/{project_id}/{startDate}/{endDate}")
	public List<Report> getReportsOfEmployeeByDateRange(@PathVariable("project_id") int project_id,
			@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate) {
		return reportService.getReportsOfEmployeeByDateRange(project_id, startDate, endDate);

	}

}
