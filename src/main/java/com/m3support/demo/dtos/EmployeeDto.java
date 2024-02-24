package com.m3support.demo.dtos;

import com.m3support.demo.entity.Account;
import com.m3support.demo.entity.Employee;
import com.m3support.demo.entity.Project;

public class EmployeeDto {
	
	private Account account_id;
		
	private Project project_id;
		
	private Employee emp_id;
	
	private String account_desc;
	
	private String project_desc;
	
	private int emp_psid;
	
	private String emp_firstname;
	
	private String emp_email;
	
	private String emp_role;
	
	

	public EmployeeDto(Account account_id, Project project_id, Employee emp_id, String account_desc,String project_desc, int emp_psid, String emp_firstname, String emp_email, String emp_role)
	
	{
		this.account_id = account_id;
		this.project_id = project_id;
		this.emp_id = emp_id;
		this.account_desc = account_desc;
		this.project_desc = project_desc;
		this.emp_psid = emp_psid;
		this.emp_firstname = emp_firstname;
		this.emp_email = emp_email;
		this.emp_role = emp_role;
	}

	public Account getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Account account_id) {
		this.account_id = account_id;
	}

	public String getAccount_desc() {
		return account_desc;
	}

	public void setAccount_desc(String account_desc) {
		this.account_desc = account_desc;
	}

	public Project getProject_id() {
		return project_id;
	}

	public void setProject_id(Project project_id) {
		this.project_id = project_id;
	}

	public String getProject_desc() {
		return project_desc;
	}

	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}

	public Employee getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee emp_id) {
		this.emp_id = emp_id;
	}

	public int getEmp_psid() {
		return emp_psid;
	}

	public void setEmp_psid(int emp_psid) {
		this.emp_psid = emp_psid;
	}

	public String getEmp_firstname() {
		return emp_firstname;
	}

	public void setEmp_firstname(String emp_firstname) {
		this.emp_firstname = emp_firstname;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	@Override
	public String toString() {
		return "EmployeeDto [account_id=" + account_id + ", account_desc=" + account_desc + ", project_id=" + project_id
				+ ", project_desc=" + project_desc + ", emp_id=" + emp_id + ", emp_psid=" + emp_psid
				+ ", emp_firstname=" + emp_firstname + ", emp_email=" + emp_email + ", emp_role=" + emp_role + "]";
	}

	
}
