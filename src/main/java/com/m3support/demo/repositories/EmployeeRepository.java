package com.m3support.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.m3support.demo.dtos.FomerEmployeeDto;
import com.m3support.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
//	@Query("SELECT new com.m3support.demo.dtos.EmployeeDto(ae.account_id, ae.project_id, ae.emp_id,"
//			+ " a.account_desc, p.project_desc,"
//			+ " e.emp_psid, e.emp_firstname, e.emp_email, e.emp_role) "
//			+ "FROM AccountProjectEmployee ae INNER JOIN ae.account_id a ON ae.account_id.account_id = a.account_id "
//			+ "INNER JOIN ae.project_id p ON ae.project_id.project_id = p.project_id "
//			+ "INNER JOIN ae.emp_id e ON ae.emp_id.emp_id = e.emp_id WHERE e.emp_id.emp_email = ?1")
//    List<FomerEmployeeDto> getEmployeeDashboard(String emp_email);

	
	
}
