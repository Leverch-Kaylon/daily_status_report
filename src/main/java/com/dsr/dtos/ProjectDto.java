package com.dsr.dtos;

import com.dsr.entity.Account;
import com.dsr.entity.Employee;
import java.sql.Date;

public class ProjectDto {

	private int project_id;

	private String project_desc;

	private String modified_by;

	// Account default constructor
	public ProjectDto() {

	}

	public ProjectDto(int project_id, String project_desc, Employee reporting_manager, Account account_id,
				   boolean deleted, java.sql.Date created_on, String created_by, java.sql.Date modified_on, String modified_by) {
		this.project_id = project_id;
		this.project_desc = project_desc;

	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
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


	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_desc=" + project_desc + "]";
	}

}