package com.dsr.dtos;

import com.dsr.entity.Account;
import com.dsr.entity.Employee;
import java.sql.Date;

public class ProjectDto {

	private int project_id;

	private String project_desc;

	private Employee reporting_manager;

	private Account account_master;
	private boolean deleted = false;
	private java.sql.Date created_on;
	private String created_by;
	private java.sql.Date modified_on;
	private String modified_by;

	// Account default constructor
	public ProjectDto() {

	}

	public ProjectDto(int project_id, String project_desc, Employee reporting_manager, Account account_master,
				   boolean deleted, java.sql.Date created_on, String created_by, java.sql.Date modified_on, String modified_by) {
		this.project_id = project_id;
		this.project_desc = project_desc;
		this.reporting_manager = reporting_manager;
		this.account_master = account_master;
		this.deleted = deleted;
		this.created_on = created_on;
		this.created_by = created_by;
		this.modified_on = modified_on;
		this.modified_by = modified_by;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_desc() {
		return project_desc;
	}

	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}

	public Employee getReporting_manager() {
		return reporting_manager;
	}

	public void setReporting_manager(Employee reporting_manager) {
		this.reporting_manager = reporting_manager;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public java.sql.Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(java.sql.Date created_on) {
		this.created_on = created_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public java.sql.Date getModified_on() {
		return modified_on;
	}

	public void setModified_on(Date modified_on) {
		this.modified_on = modified_on;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Account getAccount_master() {
		return account_master;
	}

	public void setAccount_master(Account account_master) {

		this.account_master = account_master;
	}

	public void setReportingManager_master(Employee employee_master) {

		this.reporting_manager = employee_master;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_desc=" + project_desc + ", reporting_manager="
				+ reporting_manager + ", account_master=" + account_master + ", deleted=" + deleted + ", created_on="
				+ created_on + ", created_by=" + created_by + ", modified_on=" + modified_on + ", modified_by="
				+ modified_by + "]";
	}

}