package com.dsr.entity;

import java.io.Serializable;
import java.sql.Date;


public class ReportId implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Date submissionDate;
	private int project_id;
	private int emp_id;
	
	public ReportId() {
		// TODO Auto-generated constructor stub
	}

	public ReportId(Date submissionDate, int project_id, int emp_id) {
		this.submissionDate = submissionDate;
		this.project_id = project_id;
		this.emp_id = emp_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emp_id;
		result = prime * result + project_id;
		result = prime * result + ((submissionDate == null) ? 0 : submissionDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportId other = (ReportId) obj;
		if (emp_id != other.emp_id)
			return false;
		if (project_id != other.project_id)
			return false;
		if (submissionDate == null) {
			if (other.submissionDate != null)
				return false;
		} else if (!submissionDate.equals(other.submissionDate))
			return false;
		return true;
	}
	
	
	
}
