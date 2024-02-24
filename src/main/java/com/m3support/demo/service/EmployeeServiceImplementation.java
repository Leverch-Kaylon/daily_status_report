package com.m3support.demo.service;

import java.util.List;

import com.m3support.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.m3support.demo.dtos.EmployeeDto;
import com.m3support.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	@GetMapping("/employee/employeeDashboard")
	public List<EmployeeDto> getEmployeeDashboard(String emp_email) {
		
		return employeeRepository.getEmployeeDashboard(emp_email);
	}

	@Override
	public ResponseEntity<Employee> addEmployee(Employee employee) {
		return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
	}


}
