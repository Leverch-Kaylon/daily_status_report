package com.dsr.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dsr.dtos.EmployeeDto;
import com.dsr.dtos.ProjectDto;
import com.dsr.exceptionHandling.DataNotFound;
import com.dsr.mapping.MappingMapper;
import com.dsr.entity.AccountProjectEmployee;
import com.dsr.entity.Employee;
import com.dsr.repositories.ProjectEmployeeAccount;
import com.google.common.flogger.FluentLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.dsr.dtos.FomerEmployeeDto;
import com.dsr.repositories.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectEmployeeAccount employeeAssignAccount;

	@PersistenceContext
	private EntityManager entityManager;

	private static final FluentLogger logger = FluentLogger.forEnclosingClass();

	@Override
	public List<FomerEmployeeDto> getEmployeeDashboard(String emp_email) {
		
		return null; //employeeRepository.getEmployeeDashboard(emp_email);
	}

	@Override
	public EmployeeDto addEmployee(Employee employee) {
		logger.atInfo().log("Service Layer : Adding Employee");
		employee.setCreated_on(Date.valueOf(LocalDate.now()));
		employee.setModified_on(Date.valueOf(LocalDate.now()));
		return MappingMapper.INSTANCE.toDto(employeeRepository.save(employee));
	}

	@Override
	public List<EmployeeDto> getAllEmployees(String role) {
		logger.atInfo().log("Service Layer : Get all Employees");
		List<EmployeeDto> dtoEmployees = new ArrayList<>();
		List<Employee> allEmployees;
		if (role.equals("All")) {
			allEmployees = employeeRepository.findAll();
		}else{
			allEmployees = employeeRepository.findEmployeesByRole(role);
		}
		allEmployees.forEach(e -> dtoEmployees.add(MappingMapper.INSTANCE.toDto(e)) );
		return dtoEmployees;
	}

		@Override
		public EmployeeDto findEmployeeOnID(int empID){
			logger.atInfo().log("Service Layer : Find Employees on ID " + empID);
			Employee foundEmployee = employeeRepository.findById(empID).orElseThrow(() -> new DataNotFound("Employee with ID :"+empID+" not found"));
			return MappingMapper.INSTANCE.toDto(foundEmployee);
		}

	@Override
	public Employee findEmployeeOnIDReference(int empID) {
		logger.atInfo().log("Service Layer : Find Employee Reference on ID " + empID);
		EmployeeDto empl = new EmployeeDto();
		empl.setEmp_id(empID);
		return entityManager.getReference(Employee.class, empl.getEmp_id());
	}

	@Override
	public AccountProjectEmployee assignEmployeeToProject(AccountProjectEmployee assignEmployee){
		logger.atInfo().log("Service Layer : Assigning employee with ID:" + assignEmployee.getEmp_id()+" to project with ID:" +assignEmployee.getProject_id());
		return employeeAssignAccount.save(assignEmployee);
	}

}
