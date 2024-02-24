package com.m3support.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3support.demo.dtos.DSRResponse;
import com.m3support.demo.entity.Report;
import com.m3support.demo.repositories.ReportRepository;
import com.m3support.demo.service.ReportService;

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
	public List<Report> getDSROfSpecificEmployee(@PathVariable("emp_id") int emp_id,@PathVariable("project_id") int 			project_id){
					 
				return reportService.getDSROfSpecificEmployeeByMonth(emp_id,project_id);
				
	}

	// Method that allows an employee to submit their daily status report.
	@PostMapping("/employee/createDSR")
	public DSRResponse createDSR(@RequestBody Report report) throws Exception {

		boolean exists = reportRepository.existsBySubmissionDate(report.getSubmissionDate());
		DSRResponse response = new DSRResponse();
		if (exists) {
			response.setStatus(false);
			response.setErrorMessage("You have already sucessfully submitted your daily status report for the day : "
					+ report.getSubmissionDate());
			return response;
		}

		this.reportService.createDSR(report);
		response.setStatus(true);
		response.setErrorMessage("Successfully submitted DSR");
		return response;
	}

}
