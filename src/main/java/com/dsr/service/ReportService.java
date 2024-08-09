package com.dsr.service;

import java.sql.Date;
import java.util.List;

import com.dsr.dtos.DSRResponse;
import com.dsr.dtos.ReportDTO;
import com.dsr.entity.Report;
import org.springframework.http.ResponseEntity;

public interface ReportService {


	// List<Report> getDSROfSpecificEmployee(int emp_id);

	List<ReportDTO> getDSROfSpecificEmployeeByMonth(int emp_id, int project_id);

	List<ReportDTO> getEmployeeDSRUnderProjects(int project_id, Date startDate, Date endDate);

	public DSRResponse createDSR(Report report, int accountID, int employeeID, int projectID) throws Exception;

//	public String generateDSRReport(Date currentDate) throws Exception;

}
