package com.m3support.demo.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.m3support.demo.entity.Report;
import com.m3support.demo.entity.ReportId;

@Repository
public interface ReportRepository extends JpaRepository<Report, ReportId> {

	@Query("SELECT rep FROM Report rep WHERE rep.emp_id.emp_id =?1")
	List<Report> getDSROfSpecificEmployee(int emp_id);

	@Query("SELECT rep FROM Report rep WHERE rep.emp_id.emp_id =?1 AND rep.project_id.project_id =?2 AND rep.submissionDate.	submissionDate BETWEEN ?3 AND ?4")
	List<Report> getDSROfSpecificEmployeeByMonth(int emp_id,int project_id,Date endDate,Date startDate);

	@Query("SELECT rep FROM Report rep WHERE rep.submissionDate =?1")
	List<Report> generateDSRReport(Date currentDate);

	@Query("SELECT rep from Report rep where rep.project_id.project_id = ?1 ")
	List<Report> getEmployeesDSRUnderProjects(int project_id);

	@Query("SELECT rep from Report rep where rep.project_id.id = ?1 AND rep.submissionDate = ?2")
	List<Report> getEmployeesDSRUnderProjectsForToday(int projectId, Date today);

	@Query("SELECT rep from Report rep where rep.project_id.id = ?1 AND rep.submissionDate = ?2 order by rep.submissionDate")
	List<Report> getEmployeesDSRUnderProjectsByDate(int projectId, Date date);

	@Query("SELECT rep FROM Report rep WHERE rep.project_id.project_id =?1 AND rep.submissionDate BETWEEN ?2 AND ?3")
	List<Report> getReportsOfEmployeeByDateRange(int project_id, Date startDate, Date endDate);

//	@Query("SELECT rep from Report rep where rep.project_id.id = ?1 AND rep.submissionDate = ?2 AND rep.emp_id")
//	Optional<Report> existsBySubmissionDate(int projectID,String date,int employeeID);

}
