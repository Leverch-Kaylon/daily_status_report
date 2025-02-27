package com.dsr.entity;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@NoArgsConstructor
public class ReportId implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private LocalDate submission_date;
	private int project_id;
	private int emp_id;

	public ReportId(LocalDate submission_date, int project_id, int emp_id) {
		this.submission_date = submission_date;
		this.project_id = project_id;
		this.emp_id = emp_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emp_id;
		result = prime * result + project_id;
		result = prime * result + ((submission_date == null) ? 0 : submission_date.hashCode());
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
		if (submission_date == null) {
			if (other.submission_date != null)
				return false;
		} else if (!submission_date.equals(other.submission_date))
			return false;
		return true;
	}
	
	
	
}
