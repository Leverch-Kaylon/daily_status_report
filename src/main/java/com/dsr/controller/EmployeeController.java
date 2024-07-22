package com.dsr.controller;

import java.util.List;

import com.dsr.repositories.ReportRepository;
import com.dsr.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dsr.dtos.DSRResponse;
import com.dsr.entity.Report;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
    ReportService reportService;

	@Autowired
    ReportRepository reportRepository;

	// Method to retrieve an employees submitted reports by their employee id.
	//Method to for a manager to retrieve a specific employees submitted reports by their employee id.
	@GetMapping("/employee/viewDSR/{emp_id}/{project_id}")
	public List<Report> getDSROfSpecificEmployee(@PathVariable("emp_id") int emp_id,@PathVariable("project_id") int project_id){
					 
				return reportService.getDSROfSpecificEmployeeByMonth(emp_id,project_id);
				
	}

	// Method that allows an employee to submit their daily status report.
	@PostMapping("/employee/createDSR")
	public ResponseEntity<DSRResponse> createDSR(@RequestBody Report report,
												@RequestParam(name = "accountID") int accountID, @RequestParam(name = "employeeID") int employeeID,
												@RequestParam(name = "projectID") int projectID) throws Exception {

//		boolean exists = reportRepository.existsBySubmissionDate(report.getSubmissionDate());
		DSRResponse response = new DSRResponse();

		return this.reportService.createDSR(report,accountID,employeeID,projectID);
	}

}
