package com.dsr.controller;

import java.util.Date;
import java.util.List;

import com.dsr.dtos.AccountDto;
import com.dsr.dtos.EmployeeDto;
import com.dsr.dtos.FomerEmployeeDto;
import com.dsr.dtos.ProjectDto;
import com.dsr.entity.*;
import com.dsr.service.AccountService;
import com.dsr.service.EmployeeService;
import com.dsr.service.ProjectService;
import com.dsr.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	// Method to view all accounts.
	@GetMapping("/admin/viewAccounts")
	public ResponseEntity<List<AccountDto>> getAllAccounts() {

		return accountService.getAllAccounts();

	}

	// Method to view all employees submitted reports.
	@GetMapping("/admin/viewReports")
	public List<Report> getAllDSRReports() {

		return reportService.getAllDSRReports();
	}


	//All projects are to be assigned/created under an account
	//The request accepts query parameter which contains ID to the reporting manager and ID to account
	@PostMapping("/admin/createproject")
	public ResponseEntity<ProjectDto> createProject(@RequestParam(name = "accountId", required = true) int accountId, @RequestBody Project project, @RequestParam(name="reportingManager",required = true) int reportingManagerID) {
		return this.projectService.createProject(accountId, project, reportingManagerID);
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


	//Create employee(Intermittent solution, ideally would want employee to come from 3rd party(AD integration or something))
	@PostMapping("/admin/employee")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
		//return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
	}

	@GetMapping("/admin/employees")
	public ResponseEntity<List<EmployeeDto>> getAllemployees(){
		return employeeService.getAllEmloyees();
	}

	//Don't really need endpoint for all projects?

	//Get projects Under account, query parameter to filer on account
	@GetMapping("/admin/account/projects")
	public ResponseEntity<List<ProjectDto>> getProjectsUnderAccount(@RequestParam(name = "account",required = false) int accountID){
	return projectService.getProjectsUnderAccount(accountID);
	}

	//Get projects under specific reporting manager
	//Cannot have the same mapping
	@GetMapping("/admin/manager/projects")
	public ResponseEntity<List<ProjectDto>> getProjectsUnderPM(@RequestParam(name = "manager",required = false) int managerID){
		return projectService.getProjectsUnderManager(managerID);
	}

	//Query parameters include accountID,EmpID,Proj ID, the remaining are header parameters
	@PostMapping("/admin/assign/employee")
	public void assignProjectToEmployee(@RequestParam(name = "accountID") int accountID, @RequestParam(name = "employeeID") int employeeID,
										@RequestParam(name = "projectID") int projectID, @RequestHeader(name = "created_by") String created_by,
										@RequestHeader(name = "created_on") Date created_on, @RequestHeader(name = "modified_by") String modified_by,
										@RequestHeader(name = "modified_on") Date modified_on){

		//pull user information based on IDs
		//Need to get product, employee, account
		 Project proj =  projectService.findProjectOnID(projectID);
		 Account acc =  accountService.findAccountOnID(accountID);
		 Employee employee =  employeeService.findEmployeeOnID(employeeID);
		 //Populate the entity by searching for account, project and employee
		employeeService.assignEmployeeToProject(new AccountProjectEmployee(acc,employee,proj,false,created_on,created_by,modified_on,modified_by));
	}

}
