package com.dsr.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.dsr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsr.entity.Report;
import com.dsr.entity.ReportId;

@Repository
public interface ReportRepository extends JpaRepository<Report, ReportId> {

	@Query("SELECT rep FROM Report rep WHERE rep.emp_id.emp_id =?1")
	List<Report> getDSROfSpecificEmployee(int emp_id);

	@Query("SELECT rep FROM Report rep WHERE rep.emp_id.emp_id =?1 AND rep.project_id.project_id =?2 AND rep.submissionDate.submissionDate BETWEEN ?3 AND ?4")
	List<Report> getDSROfSpecificEmployeeByMonth(int emp_id,int project_id,Date endDate,Date startDate);

	@Query("SELECT rep FROM Report rep WHERE rep.submissionDate =?1")
	List<Report> generateDSRReport(Date currentDate);

	@Query("SELECT rep from Report rep where rep.project_id.project_id = ?1 AND rep.submissionDate BETWEEN ?2 AND ?3 order by rep.submissionDate")
	List<Report> getEmployeesDSRUnderProjects(int project_id, Date startDate, Date endDate);

	@Query("SELECT rep from Report rep where rep.project_id.id = ?1 AND rep.submissionDate = ?2 AND rep.emp_id.emp_id = ?3")
	Optional<Report> existsBySubmissionDate( int projectID, Date date, int employeeID);

}
