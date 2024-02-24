package com.m3support.demo.service;

import java.sql.Date;
import java.util.List;

import com.m3support.demo.entity.Report;

public interface ReportService {

	List<Report> getAllDSRReports();

	// List<Report> getDSROfSpecificEmployee(int emp_id);

	List<Report> getDSROfSpecificEmployeeByMonth(int emp_id, int project_id);

	List<Report> getEmployeeDSRUnderProjects(int project_id);

	public String createDSR(Report report) throws Exception;

	public String generateDSRReport(Date currentDate) throws Exception;

	// Method Returns reports under an account for today(System date)
	List<Report> getEmployeeDSRUnderProjectsForToday(int projectId);

	// Methods takes input from datepicker to return reports for that day
	List<Report> getEmployeeDSRUnderProjectsByDate(int projectId, Date todayDate);

	// Method takes input from datepicker to return a range of reports by a project
	List<Report> getReportsOfEmployeeByDateRange(int project_id, Date startDate, Date endDate);

}
