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

import javax.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Employee {

	@Autowired
    ReportService reportService;

	@Autowired
    ReportRepository reportRepository;

	// Method to retrieve an employees submitted reports by their employee id.
	//Method to for a manager to retrieve a specific employees submitted reports by their employee id.
	@Operation(summary = "Get DSR Of Employee")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =ReportDTO.class))}),
			@ApiResponse(responseCode = "404", description = "Data not found",content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@GetMapping("/employee/DSR/{emp_id}/{project_id}")
	public ResponseEntity<List<ReportDTO>> getDSROfSpecificEmployee(@PathVariable("emp_id") int emp_id, @PathVariable("project_id") int project_id){
				return new ResponseEntity<>(reportService.getDSROfSpecificEmployeeByMonth(emp_id,project_id), HttpStatus.OK);
	}

	// Method that allows an employee to submit their daily status report.
	@Operation(summary = "Employee Create DSR")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation =DSRResponse.class))}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(mediaType = "application/json")})

	})
	@PostMapping("/employee/DSR/{emp_id}")
	public ResponseEntity<DSRResponse> createDSR(@Valid @RequestBody Report report,
												@RequestParam(name = "accountID") int accountID, @PathVariable(name = "emp_id", required = true) int employeeID,
												@RequestParam(name = "projectID") int projectID) throws Exception {
		return new ResponseEntity<>(this.reportService.createDSR(report,accountID,employeeID,projectID),HttpStatus.OK);
	}

}
