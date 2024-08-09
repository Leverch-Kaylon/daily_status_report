package com.dsr.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsr.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

@Query("SELECT proj FROM Project proj WHERE proj.account_id.account_id =?1 ")
Optional<Project> findProjectUnderAccounts(int account_id);
//
//	@Query("SELECT new com.m3support.demo.dtos.ProjectDto(p.project_id, p.project_desc,"
//			+ " a.account_id, a.account_desc,"
//			+ " p.modified_on, p.modified_by, p.created_on, p.created_by, p.deleted) "
//			+ "FROM Project p INNER JOIN p.account_id a ON p.account_id.account_id = a.account_id ")
//	List<ProjectDto> getProjectsDashboard();
//
	@Query("SELECT proj FROM Project proj WHERE proj.reporting_manager.emp_id = ?1 AND proj.account_id.account_id = ?2")
	List<Project> getProjectsUnderManager(int reporting_manager, int account_id);
//
}
