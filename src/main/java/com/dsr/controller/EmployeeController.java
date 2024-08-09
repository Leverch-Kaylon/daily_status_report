package com.dsr.controller;

import java.util.List;

import com.dsr.dtos.ReportDTO;
import com.dsr.repositories.ReportRepository;
import com.dsr.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	@GetMapping("/employee/DSR/{emp_id}/{project_id}")
	public ResponseEntity<List<ReportDTO>> getDSROfSpecificEmployee(@PathVariable("emp_id") int emp_id, @PathVariable("project_id") int project_id){
				return new ResponseEntity<>(reportService.getDSROfSpecificEmployeeByMonth(emp_id,project_id), HttpStatus.OK);
	}

	// Method that allows an employee to submit their daily status report.
	@PostMapping("/employee/DSR/{emp_id}")
	public ResponseEntity<DSRResponse> createDSR(@RequestBody Report report,
												@RequestParam(name = "accountID") int accountID, @PathVariable(name = "emp_id", required = true) int employeeID,
												@RequestParam(name = "projectID") int projectID) throws Exception {
		return new ResponseEntity<>(this.reportService.createDSR(report,accountID,employeeID,projectID),HttpStatus.OK);
	}

}
