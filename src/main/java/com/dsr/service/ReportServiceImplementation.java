package com.dsr.service;

import java.io.FileOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.dsr.dtos.ReportDTO;
import com.dsr.entity.Account;
import com.dsr.entity.Employee;
import com.dsr.entity.Project;
import com.dsr.entity.Report;
import com.dsr.mapping.MappingMapper;
import com.dsr.repositories.ReportRepository;
import com.dsr.dtos.DSRResponse;
import com.dsr.repositories.AccountRepository;
import com.dsr.repositories.EmployeeRepository;
import com.dsr.repositories.ProjectRepository;
import com.google.common.flogger.FluentLogger;
import org.mapstruct.Mapping;
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

	private static final FluentLogger logger = FluentLogger.forEnclosingClass();

	// Method to retrieve an employees submitted reports by their psid.
	@Override
	public List<ReportDTO> getDSROfSpecificEmployeeByMonth(int emp_id, int project_id) {
		logger.atInfo().log("Report Service Layer : Get Reports within current month for user "+emp_id+" for projectID "+project_id);
		List<Report> report = reportRepository.getDSROfSpecificEmployeeByMonth(emp_id, project_id,
				Date.valueOf(LocalDate.now().minusMonths(1)), Date.valueOf(LocalDate.now()));
		List<ReportDTO> reportResponse = new ArrayList<>();
		report.forEach(r -> reportResponse.add(MappingMapper.INSTANCE.toReportDTO(r)));
		return reportResponse;
	}

	// Method that allows an employee to submit their daily report.
	@Override
	public DSRResponse createDSR(Report report, int accountID, int employeeID, int projectID) throws Exception {
		report.setSubmissionDate(Date.valueOf(LocalDate.now()));
		Optional<Report> exists = reportRepository.existsBySubmissionDate(projectID,report.getSubmissionDate(),employeeID);

		if (exists.isPresent()) {
			logger.atInfo().log("Report Service Layer : Saving DSR for date " + LocalDate.now()+" for user " + employeeID +" has already been SUBMITTED");
			return new DSRResponse(true,"","You have already sucessfully submitted your daily status report for the day :"
					+ report.getSubmissionDate());
		}else {
			logger.atInfo().log("Report Service Layer : Saving DSR for date " + LocalDate.now()+" for user " + employeeID);
			Project proj =  projectRepo.findById(projectID).get();
			Account acc =  accountRepo.findById(accountID).get();
			Employee employee =  employeeRepo.findById(employeeID).get();

			report.setAccount_id(acc);
			report.setEmp_id(employee);
			report.setProject_id(proj);
			this.reportRepository.save(report);

			return new DSRResponse(true,"Successfully submitted DSR","");
		}

	}
//
//	// Method that allows a manager to generate a PDF report.
//	public String generateDSRReport(Date currentDate) throws Exception {
//
//		List<Report> generateDSRReport = reportRepository.generateDSRReport(currentDate);
//
//		Document document = new Document(PageSize.A4);
//
//		String fileLocation = "";
//
//		PdfWriter.getInstance(document, new FileOutputStream(fileLocation));
//		document.open();
//		document.add(new Paragraph("List of Employee Daily Status Reports for : " + currentDate));
//
//		PdfPTable table = new PdfPTable(5);
//		table.setWidthPercentage(100);
//		table.setSpacingBefore(15);
//
//		addTableHeader(table);
//		addRows(table, generateDSRReport);
//		document.add(table);
//
//		document.close();
//
//		return "PDF File Has Successfully Been Extracted and Saved At The Following Location : " + fileLocation;
//
//	}
//
//	private void addTableHeader(PdfPTable table)
//
//	{
//		Stream.of("Employee PSID", "Employee Name", "Task Completed For The Day", "Task Planned for Tommorow",
//				"Difficulties/Issues Experienced")
//
//				.forEach(columnTitle ->
//
//				{
//					PdfPCell header = new PdfPCell();
//					header.setBackgroundColor(BaseColor.LIGHT_GRAY);
//					header.setPhrase(new Phrase(columnTitle));
//					table.addCell(header);
//
//				}
//
//				);
//
//	}
//
//	private void addRows(PdfPTable table, List<Report> generateDSRReport) throws Exception
//
//	{
//
//		for (int i = 0; i < generateDSRReport.size(); i++)
//
//		{
//			table.addCell(Integer.toString(generateDSRReport.get(i).getEmp_id().getEmp_psid()));
//			table.addCell(generateDSRReport.get(i).getEmp_id().getEmp_firstname());
//			table.addCell(generateDSRReport.get(i).getTask_completed());
//			table.addCell(generateDSRReport.get(i).getTask_planned());
//			table.addCell(generateDSRReport.get(i).getTask_issues());
//		}
//
//	}

	@Override
	public List<ReportDTO> getEmployeeDSRUnderProjects(int project_id, Date startDate, Date endDate) {

		List<Report> reports = reportRepository.getEmployeesDSRUnderProjects(project_id, startDate, endDate);
		List<ReportDTO> dtoReports = new ArrayList<>();
		reports.forEach(r -> dtoReports.add(MappingMapper.INSTANCE.toReportDTO(r)));
		return dtoReports;

	}
}
