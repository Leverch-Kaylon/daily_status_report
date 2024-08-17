package com.dsr.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.util.*;


import com.dsr.dtos.AccountDto;
import com.dsr.dtos.EmployeeDto;
import com.dsr.dtos.FomerEmployeeDto;
import com.dsr.dtos.ProjectDto;
import com.dsr.entity.*;
import com.dsr.mapping.MappingMapper;
import com.dsr.service.AccountService;
import com.dsr.service.EmployeeService;
import com.dsr.service.ProjectService;
import com.dsr.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Below CORS was for Angular front end
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
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
	@PostMapping("/account")
	public ResponseEntity<AccountDto> createAccount(@RequestBody Account account) {
		return new ResponseEntity<AccountDto>(accountService.createAccount(account),HttpStatus.OK);
	}

	@PatchMapping("/account/{id}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable(name="id") int accountID, @RequestBody AccountDto account) {
		return new ResponseEntity<>(MappingMapper.INSTANCE.toAccountDTO(accountService.updateAccount(accountID,account)),HttpStatus.OK);
	}

	@PatchMapping("/project/{projectId}")
	public ResponseEntity<ProjectDto> updateProject(@PathVariable("projectId") int projectId,
							  @RequestParam(name = "reporting_manager", required = false) Optional<Integer> reportingManager,
							  @RequestParam(name = "account_id", required = false) Optional<Integer> accountID,
			@RequestBody ProjectDto project) {
		return new ResponseEntity<>(MappingMapper.INSTANCE.toProjectDTO(projectService.updateProject(projectId,reportingManager.orElse(0),accountID.orElse(0), project)),HttpStatus.OK);

	}

	// Method to view all accounts.
	@GetMapping("/account")
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
		return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
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

	//TODO Method that retrieves employee details by the employee email_id .
//	@GetMapping("/admin/employee/{emp_email}")
//	public List<FomerEmployeeDto> employeeDashboard(@PathVariable("emp_email") String emp_email) {
//		return employeeService.getEmployeeDashboard(emp_email.toLowerCase());
//	}




	//Create employee(Intermittent solution, ideally would want employee to come from 3rd party(Federated credentials or something))
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.OK);
	}

	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(name = "role", required = false) Optional<String> role){
		return new ResponseEntity<>(employeeService.getAllEmployees(role.orElse("All")),HttpStatus.OK);
	}

	//Get projects Under account, query parameter to filer on account
	@GetMapping("/project")
	public ResponseEntity<List<ProjectDto>> getProjectsUnderAccount(@RequestParam(name = "account",required = false) Optional<Integer> accountID){
	return new ResponseEntity<List<ProjectDto>>(projectService.getProjectsUnderAccount(accountID.orElse(0)),HttpStatus.OK);
	}

	//All projects are to be assigned/created under an account
	//The request accepts query parameter which contains ID to the reporting manager and ID to account
	@PostMapping("/project")
	public ResponseEntity<ProjectDto> createProject(@RequestParam(name = "accountId", required = true) int accountId, @RequestBody Project project, @RequestParam(name="reportingManager",required = true) int reportingManagerID) {
		return new ResponseEntity<>(projectService.createProject(accountId, project, reportingManagerID),HttpStatus.OK);
	}

	//Get specific user
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable(name = "id",required = true) int employeeID){
		return new ResponseEntity<EmployeeDto>(employeeService.findEmployeeOnID(employeeID),HttpStatus.OK);
	}

	//Query parameters include accountID,EmpID,Proj ID, the remaining are header parameters
	@PostMapping("/assign/employee")
	public ResponseEntity<Void> assignProjectToEmployee(@RequestParam(name = "accountID") int accountID, @RequestParam(name = "employeeID") int employeeID,
										@RequestParam(name = "projectID") int projectID, @RequestHeader(name = "created_by") String created_by,
										@RequestHeader(name = "modified_by") String modified_by)
	{

		//pull user information based on IDs
		//Need to get product, employee, account
		 Project proj =  projectService.findProjectByIDReference(projectID);
		 Account acc =  accountService.findAccountOnIDReference(accountID);
		 Employee employee =  employeeService.findEmployeeOnIDReference(employeeID);
		 //Populate the entity by searching for account, project and employee
		employeeService.assignEmployeeToProject(new AccountProjectEmployee(acc,employee,proj,false,Date.valueOf(LocalDate.now()),created_by, Date.valueOf(LocalDate.now()),modified_by));
        return new ResponseEntity<>(HttpStatus.OK);
	}

	// Method that returns all projects under an account.
	@GetMapping("/project/{account_id}")
	public ResponseEntity<List<ProjectDto>> getAllProjectsUnderAccount(@PathVariable int account_id) {

		return new ResponseEntity<>(projectService.getProjectsUnderAccount(account_id),HttpStatus.OK);

	}


}
