package com.dsr.service;

import java.io.FileOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import com.dsr.entity.Account;
import com.dsr.entity.Employee;
import com.dsr.entity.Project;
import com.dsr.entity.Report;
import com.dsr.repositories.ReportRepository;
import com.dsr.dtos.DSRResponse;
import com.dsr.repositories.AccountRepository;
import com.dsr.repositories.EmployeeRepository;
import com.dsr.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ReportServiceImplementation implements ReportService {

	@Autowired
    ReportRepository reportRepository;

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	ProjectRepository projectRepo;

	// Method to retrieve all employees submitted reports.
	@Override
	public List<Report> getAllDSRReports() {

		return reportRepository.findAll();
	}

	// Method to retrieve an employees submitted reports by their psid.
	@Override
	public List<Report> getDSROfSpecificEmployeeByMonth(int emp_id, int project_id) {

		return reportRepository.getDSROfSpecificEmployeeByMonth(emp_id, project_id,
				Date.valueOf(LocalDate.now().minusMonths(1)), Date.valueOf(LocalDate.now()));

	}

	// Method that allows an employee to submit their daily report.
	@Override
	public ResponseEntity<DSRResponse> createDSR(Report report, int accountID, int employeeID, int projectID) throws Exception {
		//Optional<Report> exists = reportRepository.existsBySubmissionDate(projectID,String.valueOf(report.getSubmissionDate()),employeeID);

		if (false) {
			return new ResponseEntity<DSRResponse>(new DSRResponse(true,""," Error - You have already sucessfully submitted your daily status report for the day :"
					+ report.getSubmissionDate()), HttpStatus.OK);
		}else {
			Project proj =  projectRepo.findById(projectID).get();
			Account acc =  accountRepo.findById(accountID).get();
			Employee employee =  employeeRepo.findById(employeeID).get();

			report.setAccount_id(acc);
			report.setEmp_id(employee);
			report.setProject_id(proj);
			System.out.println(proj.getReporting_manager());
			System.out.println(employee.getEmp_firstname());
			this.reportRepository.save(report);

			return new ResponseEntity<DSRResponse>(new DSRResponse(true,"Successfully submitted DSR",""), HttpStatus.OK);
		}

	}

	// Method that allows a manager to generate a PDF report.
	public String generateDSRReport(Date currentDate) throws Exception {

		List<Report> generateDSRReport = reportRepository.generateDSRReport(currentDate);

		Document document = new Document(PageSize.A4);

		String fileLocation = "C:\\Users\\Mamello Mitane\\Desktop\\ITC_Daily_Reports\\itc_dsr_report.pdf";

		PdfWriter.getInstance(document, new FileOutputStream(fileLocation));
		document.open();
		document.add(new Paragraph("List of ITC Employee Daily Status Reports for : " + currentDate));

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);

		addTableHeader(table);
		addRows(table, generateDSRReport);
		document.add(table);

		document.close();

		return "PDF File Has Successfully Been Extracted and Saved At The Following Location : " + fileLocation;

	}

	private void addTableHeader(PdfPTable table)

	{
		Stream.of("Employee PSID", "Employee Name", "Task Completed For The Day", "Task Planned for Tommorow",
				"Difficulties/Issues Experienced")

				.forEach(columnTitle ->

				{
					PdfPCell header = new PdfPCell();
					header.setBackgroundColor(BaseColor.LIGHT_GRAY);
					header.setPhrase(new Phrase(columnTitle));
					table.addCell(header);

				}

				);

	}

	private void addRows(PdfPTable table, List<Report> generateDSRReport) throws Exception

	{

		for (int i = 0; i < generateDSRReport.size(); i++)

		{
			table.addCell(Integer.toString(generateDSRReport.get(i).getEmp_id().getEmp_psid()));
			table.addCell(generateDSRReport.get(i).getEmp_id().getEmp_firstname());
			table.addCell(generateDSRReport.get(i).getTask_completed());
			table.addCell(generateDSRReport.get(i).getTask_planned());
			table.addCell(generateDSRReport.get(i).getTask_issues());
		}

	}

	@Override
	public List<Report> getEmployeeDSRUnderProjects(int project_id) {

		return reportRepository.getEmployeesDSRUnderProjects(project_id);

	}

	// Method returns all DSR submitted uder a project for today(System Date)
	public List<Report> getEmployeeDSRUnderProjectsForToday(int projectId) {
		return reportRepository.getEmployeesDSRUnderProjectsForToday(projectId, Date.valueOf(LocalDate.now()));

	}

	// Methods returns DSR under projects by a date which is selected from
	// datepicker
	public List<Report> getEmployeeDSRUnderProjectsByDate(int projectId, Date todayDate) {
		return reportRepository.getEmployeesDSRUnderProjectsByDate(projectId, todayDate);
	}

	// Methods returns Reports under projects by a dateRange which is selected from
	// datepicker
	@Override
	public List<Report> getReportsOfEmployeeByDateRange(int project_id, Date startDate, Date endDate) {
		return reportRepository.getReportsOfEmployeeByDateRange(project_id, startDate, endDate);

	}

}
