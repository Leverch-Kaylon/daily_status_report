package com.m3support.demo.service;

import java.util.List;

import com.m3support.demo.dtos.EmployeeDto;
import com.m3support.demo.dtos.FomerEmployeeDto;
import com.m3support.demo.entity.AccountProjectEmployee;
import com.m3support.demo.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
	
   List<FomerEmployeeDto> getEmployeeDashboard(String emp_email);

   ResponseEntity<EmployeeDto> addEmployee(Employee employee);

   ResponseEntity<List<EmployeeDto>> getAllEmloyees();

   Employee findEmployeeOnID(int empID);

   ResponseEntity<AccountProjectEmployee> assignEmployeeToProject(AccountProjectEmployee assignEmployee);

   }
