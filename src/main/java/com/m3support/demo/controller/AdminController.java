package com.m3support.demo.controller;

import java.util.List;

import com.m3support.demo.dtos.*;
import com.m3support.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.m3support.demo.entity.Account;
import com.m3support.demo.entity.Project;
import com.m3support.demo.entity.Report;
import com.m3support.demo.service.AccountService;
import com.m3support.demo.service.EmployeeService;
import com.m3support.demo.service.ProjectService;
import com.m3support.demo.service.ReportService;

//Below CORS was for Angular front end
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	AccountService accountService;

	@Autowired
	ReportService reportService;

	@Autowired
	ProjectService projectService;

	@Autowired
	EmployeeService employeeService;

	// Method used to create an account.
	@PostMapping("/admin/createAccount")
	public ResponseEntity<AccountDto> createAccount(@RequestBody Account account) {

		return this.accountService.createAccount(account);


	}

	// Method used to update an account
//	@PutMapping("/admin/updateAccount")
//	public void updateAccount(@RequestBody Account account) {
//		this.accountService.updateAccount(account);
//	}
//
//	// Method to view all accounts.
//	@GetMapping("/admin/viewAccounts")
//	public List<Account> getAllAccounts() {
//
//		return accountService.getAllAccounts();
//
//	}

	// Method to view all employees submitted reports.
	@GetMapping("/admin/viewReports")
	public List<Report> getAllDSRReports() {

		return reportService.getAllDSRReports();
	}

	// Method that allows the manager to retrieve/view all projects.
	@GetMapping("/admin/viewProjects")
	public List<Project> getAllProjects() {

		return projectService.getAllProjects();

	}

	// Method used to retrieve account dashboard details.
//	@GetMapping("/admin/accountsDashboard")
//	public List<AccountDto> accountsDashboard() {
//
//		return accountService.getAccountsDashboard();
//
//	}

	// Method used to retrieve project dashboard details
//	@GetMapping("/admin/projectsDashboard")
//	public List<ProjectDto> getProjectsDashboard() {
//
//		return this.projectService.getProjectsDashboard();
//
//	}

	// Method used to retrieve account identifier details
//	@GetMapping("/admin/accountIdentifiers")
//	public List<AccountIdDto> accountIdentifiers() {
//		return accountService.getAccountsForProjects();
//	}

	// Method that retrieves employee details by the employee email_id .
	@GetMapping("/admin/employeeDashboard/{emp_email}/")
	public List<FomerEmployeeDto> employeeDashboard(@PathVariable("emp_email") String emp_email) {

		return employeeService.getEmployeeDashboard(emp_email.toLowerCase());

	}

//	@PutMapping("/admin/updateProject/{accountId}/{projectId}")
//	public void updateProject(@PathVariable("accountId") int accountId, @PathVariable("projectId") int projectId,
//			@RequestBody Project project) {
//		this.projectService.updateProject(accountId, projectId, project);
//	}

	//All projects are to be assigned/created under an account
	//The request accepts query parameter which contains ID to the reporting manager and ID to account
	@PostMapping("/admin/createproject")
	public ResponseEntity<ProjectDto> createProject(@RequestParam(name = "accountId", required = true) int accountId, @RequestBody Project project, @RequestParam(name="reportingManager",required = true) int reportingManagerID) {
		return this.projectService.createProject(accountId, project, reportingManagerID);
	}

	//Create employee(Intermittent solution, ideally would want employee to come from 3rd party(AD integration or something))
	@PostMapping("/admin/employee")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
		//return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
	}
}
