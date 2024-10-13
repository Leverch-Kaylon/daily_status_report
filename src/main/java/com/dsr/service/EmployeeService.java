package com.dsr.service;

import java.util.List;

import com.dsr.dtos.EmployeeDto;
import com.dsr.dtos.FomerEmployeeDto;
import com.dsr.entity.AccountProjectEmployee;
import com.dsr.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
	
   List<FomerEmployeeDto> getEmployeeDashboard(String emp_email);

   EmployeeDto addEmployee(Employee employee, String created_by);

   List<EmployeeDto> getAllEmployees(String role);

   EmployeeDto findEmployeeOnID(int empID);

   Employee findEmployeeOnIDReference(int empID);


   AccountProjectEmployee assignEmployeeToProject(AccountProjectEmployee assignEmployee);

   }
