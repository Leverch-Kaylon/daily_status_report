package com.dsr.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import com.dsr.dtos.ProjectDto;
import com.dsr.dtos.ReportDTO;
import com.dsr.entity.Account;
import com.dsr.service.AccountService;
import com.dsr.service.ProjectService;
import com.dsr.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/manager")
public class ManagerController {

	@Autowired
	ReportService reportService;

	@Autowired
	ProjectService projectService;

	@Autowired
	AccountService accountService;
	
//
//	// Methods used by manager to generate a PDF report.
//	@GetMapping("/manager/{currentDate}")
//	public String generateDSRReport(@PathVariable("currentDate") Date currentDate) throws Exception {
//		return reportService.generateDSRReport(currentDate);
//
//	}

	//Method that returns all the accounts under which a logged in manager has projects
	@GetMapping("/accounts/{reporting_manager}")
	public List<Account> getAccountsUnderManager(@PathVariable int reporting_manager){
		return accountService.getAccountsFromManager(reporting_manager);
	}
	
	//Method that returns all projects under a specific manager from an account
	@GetMapping("/projects/{reporting_manager}/{account_id}")
	public ResponseEntity<List<ProjectDto>> getProjectsUnderManager(@PathVariable int reporting_manager, @PathVariable int account_id){
		return new ResponseEntity<>(projectService.getProjectsUnderManager(reporting_manager, account_id), HttpStatus.OK);
	}


	// Method that returns all employees DSR under specific project.
	@GetMapping("/employees/{project_id}")
	public ResponseEntity<List<ReportDTO>> getEmployeesDSRUnderProject(@PathVariable int project_id, @RequestParam("startDate") Optional<Date> startDate, @RequestParam("endDate") Optional<Date> endDate) {
		return new ResponseEntity<>(reportService.getEmployeeDSRUnderProjects(project_id, startDate.orElse(Date.valueOf(LocalDate.now())),endDate.orElse(Date.valueOf(LocalDate.now()))),HttpStatus.OK);
	}

	//TODO manager add comment to DSR update
	//TODO enhancement required, new column in Report DB for the comment -- PHASE 2**
}
