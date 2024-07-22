package com.dsr.service;

import java.util.List;

import com.dsr.dtos.EmployeeDto;
import com.dsr.dtos.FomerEmployeeDto;
import com.dsr.entity.AccountProjectEmployee;
import com.dsr.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
	
   List<FomerEmployeeDto> getEmployeeDashboard(String emp_email);

   ResponseEntity<EmployeeDto> addEmployee(Employee employee);

   ResponseEntity<List<EmployeeDto>> getAllEmloyees();

   Employee findEmployeeOnID(int empID);

   ResponseEntity<AccountProjectEmployee> assignEmployeeToProject(AccountProjectEmployee assignEmployee);

   }
