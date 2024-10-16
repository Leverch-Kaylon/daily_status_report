package com.dsr.controller;

import java.time.LocalDate;
import java.sql.Date;
import java.util.*;


import com.dsr.dtos.AccountDto;
import com.dsr.dtos.EmployeeDto;
import com.dsr.dtos.ProjectDto;
import com.dsr.entity.*;
import com.dsr.mapping.MappingMapper;
import com.dsr.service.AccountService;
import com.dsr.service.EmployeeService;
import com.dsr.service.ProjectService;
import com.dsr.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dsr.entity.Employee;

import javax.validation.Valid;

//Below CORS was for Angular front end
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class Admin {

	@Autowired
    AccountService accountService;

	@Autowired
    ReportService reportService;

	@Autowired
    ProjectService projectService;

	@Autowired
    EmployeeService employeeService;

    // Method used to create an account.
    @Operation(summary = "Create account")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})})
	@PostMapping("/account")
	public ResponseEntity<AccountDto> createAccount( @RequestHeader(name = "created-by") String createdBy,@Valid @RequestBody Account account) {
		return new ResponseEntity<AccountDto>(accountService.createAccount(createdBy,account),HttpStatus.OK);
	}
    @Operation(summary = "Get All Projects Under an Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Data not found",content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})})
	@PatchMapping("/account/{id}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable(name="id") int accountID, @RequestBody AccountDto account) {
		return new ResponseEntity<>(MappingMapper.INSTANCE.toAccountDTO(accountService.updateAccount(accountID,account)),HttpStatus.OK);
	}

	@Operation(summary = "Update Project")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =ProjectDto.class))}),
			@ApiResponse(responseCode = "404", description = "Data not found",content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@PatchMapping("/project/{projectId}")
	public ResponseEntity<ProjectDto> updateProject(@PathVariable("projectId") int projectId,
							  @RequestParam(name = "reporting_manager", required = false) Optional<Integer> reportingManager,
							  @RequestParam(name = "account_id", required = false) Optional<Integer> accountID,
			@RequestBody ProjectDto project) {
		return new ResponseEntity<>(MappingMapper.INSTANCE.toProjectDTO(projectService.updateProject(projectId,reportingManager.orElse(0),accountID.orElse(0), project)),HttpStatus.OK);

	}

	// Method to view all accounts.
	@Operation(summary = "Get All Accounts")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =AccountDto.class))}),
			@ApiResponse(responseCode = "404", description = "Data not found",content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@GetMapping("/account")
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
		return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
	}

	//TODO ACCOUNT DASHBOARD(CONSOLIDATED INFORMATION)
//	@GetMapping("/admin/accountsDashboard")
//	public List<AccountDto> accountsDashboard() {
//
//		return accountService.getAccountsDashboard();
//
//	}

	//TODO PROJECT DASHBOARD(CONSOLIDATED INFORMATION)
//	@GetMapping("/admin/projectsDashboard")
//	public List<ProjectDto> getProjectsDashboard() {
//
//		return this.projectService.getProjectsDashboard();
//
//	}

	//TODO EMPLOYEE DASHBOARD(CONSOLIDATED INFORMATION)
//	@GetMapping("/admin/employee/{emp_email}")
//	public List<FomerEmployeeDto> employeeDashboard(@PathVariable("emp_email") String emp_email) {
//		return employeeService.getEmployeeDashboard(emp_email.toLowerCase());
//	}


	//Create employee(Intermittent solution, ideally would want employee to come from 3rd party(Federated credentials or something))
	@Operation(summary = "Add Employee")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =EmployeeDto.class))}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody Employee employee, @RequestHeader(name = "created_by") String created_by) {
		return new ResponseEntity<>(employeeService.addEmployee(employee, created_by),HttpStatus.OK);
	}

	@Operation(summary = "Get All Employees")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =EmployeeDto.class))}),
			@ApiResponse(responseCode = "404", description = "Data not found",content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(name = "role", required = false) Optional<String> role){
		return new ResponseEntity<>(employeeService.getAllEmployees(role.orElse("All")),HttpStatus.OK);
	}

	//Get projects Under account, query parameter to filer on account
	@Operation(summary = "Get Projects Under Account")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =ProjectDto.class))}),
			@ApiResponse(responseCode = "404", description = "Data not found",content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@GetMapping("/project")
	public ResponseEntity<List<ProjectDto>> getProjectsUnderAccount(@RequestParam(name = "account",required = false) Optional<Integer> accountID){
	return new ResponseEntity<List<ProjectDto>>(projectService.getProjectsUnderAccount(accountID.orElse(0)),HttpStatus.OK);
	}

	//All projects are to be assigned/created under an account
	//The request accepts query parameter which contains ID to the reporting manager and ID to account
	@Operation(summary = "Create Project")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =ProjectDto.class))}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@PostMapping("/project")
	public ResponseEntity<ProjectDto> createProject(@RequestParam(name = "accountId", required = true) int accountId, @Valid @RequestBody Project project, @RequestParam(name="reporting_manager",required = true) int reportingManagerID,@RequestHeader(name = "created_by") String created_by) {
		return new ResponseEntity<>(projectService.createProject(accountId, project, reportingManagerID, created_by),HttpStatus.OK);
	}

	//Get specific user
	@Operation(summary = "Get User By ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =EmployeeDto.class))}),
			@ApiResponse(responseCode = "404", description = "Data not found",content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable(name = "id",required = true) int employeeID){
		return new ResponseEntity<EmployeeDto>(employeeService.findEmployeeOnID(employeeID),HttpStatus.OK);
	}

	//Query parameters include accountID,EmpID,Proj ID, the remaining are header parameters
	@Operation(summary = "Assign Employee To Project")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =String.class))}),
			@ApiResponse(responseCode = "404", description = "Item not found",content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@PostMapping("/assign/employee")
	public ResponseEntity<String> assignProjectToEmployee(@RequestParam(name = "accountID") int accountID, @RequestHeader(name = "employeeID") int employeeID,
										@RequestParam(name = "projectID") int projectID, @RequestHeader(name = "created_by") String created_by)
	{
		 Project proj =  projectService.findProjectByIDReference(projectID);
		 Account acc =  accountService.findAccountOnIDReference(accountID);
		 Employee employee =  employeeService.findEmployeeOnIDReference(employeeID);
		 //Populate the entity by searching for account, project and employee
		employeeService.assignEmployeeToProject(new AccountProjectEmployee(acc,employee,proj,false,Date.valueOf(LocalDate.now()),created_by, Date.valueOf(LocalDate.now()),created_by));
        return new ResponseEntity<>("Successful",HttpStatus.OK);
	}

	// Method that returns all projects under an account.
	@Operation(summary = "Get All Projects Under an Account")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =ProjectDto.class))}),
			@ApiResponse(responseCode = "404", description = "Data not found",content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@GetMapping("/project/{account_id}")
	public ResponseEntity<List<ProjectDto>> getAllProjectsUnderAccount(@PathVariable int account_id) {

		return new ResponseEntity<>(projectService.getProjectsUnderAccount(account_id),HttpStatus.OK);

	}


}
