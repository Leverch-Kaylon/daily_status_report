package com.dsr.dtos;

public class ManagerDto {

	private int emp_id;
	private int emp_psid;
	private String empl_firstname;

	public int getEmployee_psid() {
		return emp_psid;
	}

	public ManagerDto() {
		// TODO Auto-generated constructor stub
	}

	public ManagerDto(int emp_id, int emp_psid, String empl_firstname) {
		this.emp_id = emp_id;
		this.emp_psid = emp_psid;
		this.empl_firstname = empl_firstname;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getEmp_psid() {
		return emp_psid;
	}

	public void setEmp_psid(int emp_psid) {
		this.emp_psid = emp_psid;
	}

	public String getEmpl_firstname() {
		return empl_firstname;
	}

	public void setEmpl_firstname(String empl_firstname) {
		this.empl_firstname = empl_firstname;
	}

	@Override
	public String toString() {
		return "ManagerDto [emp_id=" + emp_id + ", emp_psid=" + emp_psid + ", empl_firstname=" + empl_firstname + "]";
	}

}
