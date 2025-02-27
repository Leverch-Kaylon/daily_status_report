package com.dsr.repositories;

import java.time.LocalDate;
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

	@Query("SELECT rep FROM Report rep WHERE rep.emp_id.emp_id =:empID AND rep.project_id.project_id =:projID AND rep.submission_date BETWEEN :endDate AND :startDate")
	List<Report> getDSROfSpecificEmployeeByMonth(@Param("empID") int emp_id,@Param("projID") int project_id,@Param("endDate") LocalDate endDate,@Param("startDate") LocalDate startDate);

	@Query("SELECT rep FROM Report rep WHERE rep.submission_date =?1")
	List<Report> generateDSRReport(LocalDate currentDate);

	@Query("SELECT rep from Report rep where rep.project_id.project_id = ?1 AND rep.submission_date BETWEEN ?2 AND ?3 order by rep.submission_date")
	List<Report> getEmployeesDSRUnderProjects(int project_id, LocalDate startDate, LocalDate endDate);

	@Query("SELECT rep from Report rep where rep.project_id.id = ?1 AND rep.submission_date = ?2 AND rep.emp_id.emp_id = ?3")
	Optional<Report> existsBySubmissionDate( int projectID, LocalDate date, int employeeID);

}
