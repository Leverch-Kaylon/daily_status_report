package com.m3support.demo.service;

import java.util.List;

import com.m3support.demo.dtos.EmployeeDto;
import com.m3support.demo.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
	
   List<EmployeeDto> getEmployeeDashboard(String emp_email);

   ResponseEntity<Employee> addEmployee(Employee employee);


}
