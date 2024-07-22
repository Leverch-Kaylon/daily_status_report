
package com.dsr.entity;

import java.io.Serializable;

public class AccountProjectEmployeeId implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private int account_id;
	
	private int emp_id;
	
	private int project_id;
	
	public AccountProjectEmployeeId() {
		
	}

	public AccountProjectEmployeeId(int account_id, int emp_id, int project_id) {
		this.account_id = account_id;
		this.emp_id = emp_id;
		this.project_id = project_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_id;
		result = prime * result + emp_id;
		result = prime * result + project_id;
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
		AccountProjectEmployeeId other = (AccountProjectEmployeeId) obj;
		if (account_id != other.account_id)
			return false;
		if (emp_id != other.emp_id)
			return false;
		if (project_id != other.project_id)
			return false;
		return true;
	}

	
}
