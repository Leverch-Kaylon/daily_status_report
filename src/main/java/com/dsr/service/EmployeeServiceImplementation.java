package com.dsr.service;

import java.util.ArrayList;
import java.util.List;

import com.dsr.dtos.EmployeeDto;
import com.dsr.mapping.MappingMapper;
import com.dsr.entity.AccountProjectEmployee;
import com.dsr.entity.Employee;
import com.dsr.repositories.ProjectEmployeeAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.dsr.dtos.FomerEmployeeDto;
import com.dsr.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectEmployeeAccount employeeAssignAccount;
	
	@Override
	@GetMapping("/employee/employeeDashboard")
	public List<FomerEmployeeDto> getEmployeeDashboard(String emp_email) {
		
		return null; //employeeRepository.getEmployeeDashboard(emp_email);
	}

	@Override
	public ResponseEntity<EmployeeDto> addEmployee(Employee employee) {
		//Convert To DTO here and return DTO //how to remove some components dynamically
		EmployeeDto edited = MappingMapper.INSTANCE.toDto(employeeRepository.save(employee));
		return new ResponseEntity<>(edited, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<EmployeeDto>> getAllEmloyees() {

		List<EmployeeDto> dtoEmployees = new ArrayList<>();
		for(Employee employee :employeeRepository.findAll()){
			dtoEmployees.add(MappingMapper.INSTANCE.toDto(employee));
		}

		return new ResponseEntity<List<EmployeeDto>>(dtoEmployees,HttpStatus.OK);
	}

		public Employee findEmployeeOnID(int empID){
			return employeeRepository.findById(empID).get();
		}

	public ResponseEntity<AccountProjectEmployee> assignEmployeeToProject(AccountProjectEmployee assignEmployee){
		return new ResponseEntity<AccountProjectEmployee>(employeeAssignAccount.save(assignEmployee),HttpStatus.OK);
	}

}
